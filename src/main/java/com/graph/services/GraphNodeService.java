package com.graph.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.graph.domain.Edge;
import com.graph.domain.GraphNode;
import com.graph.domain.SigmaGraphNode;
import com.graph.repositories.GraphNodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class GraphNodeService {
    private final static Logger LOG = LoggerFactory.getLogger(GraphNodeService.class);

    @Autowired
    private GraphNodeRepository graphNodeRepository;

    public List<GraphNode> findByName(String name) {
        return graphNodeRepository.findByName(name);
    }

    @Transactional
    public Map save(String graphNodeJson) {
        Map resultMap = new HashMap();
        String code = "200";
        String msg = "success";
        try {
            JSONObject jsonObject = (JSONObject) JSON.parse(graphNodeJson);
            JSONArray sigmaNodeArray = (JSONArray) jsonObject.get("nodes");
            JSONArray edgesArray = (JSONArray) jsonObject.get("edges");
            List<SigmaGraphNode> sigmaGraphNodeList = JSONArray.parseArray(JSONArray.toJSONString(sigmaNodeArray), SigmaGraphNode.class);
            List<Edge> edgeList = JSONArray.parseArray(JSONArray.toJSONString(edgesArray), Edge.class);

            if (!ObjectUtils.isEmpty(sigmaGraphNodeList)) {
                List<GraphNode> graphNodeList = new ArrayList<>();
                for (SigmaGraphNode sigmaGraphNode : sigmaGraphNodeList) {
                    GraphNode graphNode = new GraphNode();
                    BeanUtils.copyProperties(sigmaGraphNode, graphNode);

                    Map<String, Object> properties = new HashMap<>();
                    List<Map<String, Object>> sigmaGraphNodeProperties = sigmaGraphNode.getProperties();
                    // sigma图谱节点属性跟neo4j节点属性转换
                    if (!ObjectUtils.isEmpty(sigmaGraphNodeProperties)) {
                        for (Map<String, Object> sigmaGraphNodePropertieMap : sigmaGraphNodeProperties) {
                            properties.put((String) sigmaGraphNodePropertieMap.get("propertyKey"), sigmaGraphNodePropertieMap);
                        }
                        graphNode.setProperties(properties);
                    }
                    graphNodeList.add(graphNode);
                }

                // 处理边/关系 start
                Map<String, Object> nodesIdMap = new HashMap<>();
                if (!ObjectUtils.isEmpty(graphNodeList)) {
                    for (GraphNode node : graphNodeList) {
                        nodesIdMap.put(node.getId(), node);
                    }
                }

                if (!ObjectUtils.isEmpty(edgeList)) {
                    for (Edge edge : edgeList) {
                        GraphNode startNode = (GraphNode) nodesIdMap.get(edge.getSource());
                        GraphNode endNode = (GraphNode) nodesIdMap.get(edge.getTarget());
                        edge.setStartNode(startNode);
                        edge.setEndNode(endNode);
                        startNode.getEdges().add(edge);
                    }
                }

                List<GraphNode> nodes = (List<GraphNode>) graphNodeRepository.saveAll(graphNodeList);
                resultMap.put("data", nodes);
            }


        } catch (Exception e) {
            code = "500";
            msg = "error";
            e.printStackTrace();
        }
        resultMap.put("code", code);
        resultMap.put("msg", msg);
        return resultMap;
    }

    public Map<String, Object> findAll() {
        Iterable<GraphNode> result = graphNodeRepository.findAll();
        return toD3Format(result);
    }


    private Map<String, Object> toD3Format(Iterable<GraphNode> graphNodes) {
        List<Map<String, Object>> nodes = new ArrayList<>();
        List<Map<String, Object>> rels = new ArrayList<>();
        Iterator<GraphNode> result = graphNodes.iterator();
        while (result.hasNext()) {
            Map<String, Object> node = new HashMap<>();
            GraphNode graphNode = result.next();
            node.put("id", graphNode.getId());
            node.put("label", graphNode.getLabel());
            node.put("labelName", graphNode.getLabelName());
            node.put("typeUri", graphNode.getTypeUri());
            node.put("x", graphNode.getX());
            node.put("y", graphNode.getY());
            List<Object> properties = new ArrayList<>();
            for (Object value : graphNode.getProperties().values()) {
                properties.add(value);
            }
            node.put("properties", properties);
            nodes.add(node);
            rels.addAll(handleEdges(graphNode.getEdges(), graphNode.getId()));
        }
        return map("nodes", nodes, "edges", rels);
    }

    private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
        Map<String, Object> result = new HashMap<>(1);
        result.put(key1, value1);
        result.put(key2, value2);
        return result;
    }


    private List<Map<String, Object>> handleEdges(List<Edge> graphNodes, String source) {
        List<Map<String, Object>> rels = new ArrayList<>();
        Iterator<Edge> result = graphNodes.iterator();
        while (result.hasNext()) {
            Map<String, Object> rel = new HashMap<>();
            Edge own = result.next();
            rel.put("id", own.getId());
            rel.put("source", source);
            rel.put("target", own.getId());
            rel.put("properties", own.getProperties());
            rels.add(rel);
        }
        return rels;
    }

}
