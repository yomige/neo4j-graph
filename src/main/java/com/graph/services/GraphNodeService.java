package com.graph.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graph.domain.Edge;
import com.graph.domain.GraphNode;
import com.graph.domain.SigmaGraphEdge;
import com.graph.domain.SigmaGraphNode;
import com.graph.repositories.GraphEdgeRepository;
import com.graph.repositories.GraphNodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GraphNodeService {

    private final static Logger LOG = LoggerFactory.getLogger(GraphNodeService.class);

    @Autowired
    private GraphNodeRepository graphNodeRepository;

    @Autowired
    private GraphEdgeRepository graphEdgeRepository;

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
            String caseId = (String) jsonObject.get("caseId");
            String fileId = (String) jsonObject.get("fileId");
            String fileName = (String) jsonObject.get("fileName");
            String fileContentString = (String) jsonObject.get("fileContent");
            JSONObject fileContent = JSONObject.parseObject(fileContentString);
            JSONArray sigmaNodeArray = (JSONArray) fileContent.get("nodes");
            JSONArray edgesArray = (JSONArray) fileContent.get("edges");
            List<SigmaGraphNode> sigmaGraphNodeList = JSONArray.parseArray(JSONArray.toJSONString(sigmaNodeArray), SigmaGraphNode.class);
            List<SigmaGraphEdge> sigmaGraphEdgeList = JSONArray.parseArray(JSONArray.toJSONString(edgesArray), SigmaGraphEdge.class);

            if (!ObjectUtils.isEmpty(sigmaGraphNodeList)) {
                List<GraphNode> graphNodeList = new ArrayList<>();
                for (SigmaGraphNode sigmaGraphNode : sigmaGraphNodeList) {
                    GraphNode graphNode = new GraphNode();
                    BeanUtils.copyProperties(sigmaGraphNode, graphNode);

                    // sigma图谱节点属性跟neo4j节点属性转换
                    graphNode.setProperties(JSON.toJSONString(sigmaGraphNode.getProperties()));
                    graphNode.setCaseId(caseId);
                    graphNodeList.add(graphNode);
                }

                // 处理边/关系 start
                Map<String, Object> nodesIdMap = new HashMap<>();
                if (!ObjectUtils.isEmpty(graphNodeList)) {
                    nodesIdMap = graphNodeList.stream().collect(Collectors.toMap(GraphNode::getId, s -> s));
                }

                if (!ObjectUtils.isEmpty(sigmaGraphEdgeList)) {
                    for (SigmaGraphEdge sigmaGraphEdge : sigmaGraphEdgeList) {
                        GraphNode startNode = (GraphNode) nodesIdMap.get(sigmaGraphEdge.getSource());
                        GraphNode endNode = (GraphNode) nodesIdMap.get(sigmaGraphEdge.getTarget());
                        Edge edge = new Edge();
                        BeanUtils.copyProperties(sigmaGraphEdge, edge);
                        edge.setProperties(JSON.toJSONString(sigmaGraphEdge.getProperties()));
                        edge.setStartNode(startNode);
                        edge.setEndNode(endNode);
                        startNode.getEdges().add(edge);
                    }
                }
                // 处理边/关系 end

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

    @Transactional
    public Map<String, Object> queryGraph() {
        List<GraphNode> nodes = (List<GraphNode>) graphNodeRepository.findAll();
        List<Edge> edges = (List<Edge>) graphEdgeRepository.findAll();
        return map("nodes", toSigmaNodeFormat(nodes), "edges", toSigmaEdgeFormat(edges));
    }

    /**
     * 计算最短路径
     *
     * @return
     */
    public Map<String, Object> calculateShortestPath(String sourceId, String targetId) {
        return formatShortestPathResult(graphNodeRepository.calculateShortestPath(sourceId, targetId), sourceId, targetId);
    }

    /**
     * 节点查询返回结果格式化，与前端sigma格式要求一致
     *
     * @param graphNodes
     * @return
     */
    private List<Map<String, Object>> toSigmaNodeFormat(List<GraphNode> graphNodes) {
        List<Map<String, Object>> nodes = new ArrayList<>();
        if (!ObjectUtils.isEmpty(graphNodes)) {
            for (GraphNode graphNode : graphNodes) {
                ObjectMapper m = new ObjectMapper();
                Map<String, Object> node = m.convertValue(graphNode, Map.class);
                node.put("properties", JSON.parse(graphNode.getProperties()));
                node.remove("edges");
                nodes.add(node);
            }
        }
        return nodes;
    }

    /**
     * 关系查询返回结果格式化，与前端sigma格式要求一致
     *
     * @param edges
     * @return
     */
    private List<Map<String, Object>> toSigmaEdgeFormat(List<Edge> edges) {
        List<Map<String, Object>> edgesList = new ArrayList<>();
        if (!ObjectUtils.isEmpty(edges)) {
            for (Edge edge : edges) {
                ObjectMapper m = new ObjectMapper();
                Map<String, Object> edgeMap = m.convertValue(edge, Map.class);
                edgeMap.put("cc",JSON.parse(edge.getCc()));
                edgeMap.put("properties",JSON.parse(edge.getProperties()));
                edgeMap.remove("startNode");
                edgeMap.remove("endNode");
                edgesList.add(edgeMap);
            }
        }
        return edgesList;
    }

    /**
     * 格式化最小路径返回结果
     *
     * @return
     */
    private Map<String, Object> formatShortestPathResult(List<GraphNode> graphNodes, String sourceId, String targetId) {

        Map<String, Object> result = new HashMap<>();
        result.put("sourceNode", sourceId);
        result.put("targetNode", targetId);
        Map<String, Object> nodes = new HashMap<>();
        Map<String, Object> nodesMeta = new HashMap<>();
        Map<String, Object> edgesMeta = new HashMap<>();
        Map<String, Object> edges = new HashMap<>();
        List<Map> paths = new ArrayList<>();
        if (!ObjectUtils.isEmpty(graphNodes)) {
            // convert java object to map
            ObjectMapper m = new ObjectMapper();
            Map<String, Object> pathMap = new HashMap<>();
            List<String> nodeIds = new ArrayList<>();
            List<String> edgeIds = new ArrayList<>();
            for (GraphNode node : graphNodes) {
                Map<String, Object> tempNodeMap = new HashMap<>();
                tempNodeMap.put("objectName", node.getLabelName());
                tempNodeMap.put("id", node.getId());
                tempNodeMap.put("label", node.getTypeUri());
                tempNodeMap.put("backgroundColor", "7076ed");
                tempNodeMap.put("iconColor", "ebf1fc");
                tempNodeMap.put("icon", "F1B9");
                tempNodeMap.put("labelName", node.getLabelName());
                tempNodeMap.put("category", "entity");
                nodes.put(node.getId(), tempNodeMap);
                nodesMeta.put(node.getTypeUri(), tempNodeMap);

                nodeIds.add(node.getId());

                List<Edge> edgeList = node.getEdges();
                if (!ObjectUtils.isEmpty(edgeList)) {
                    for (Edge edge : edgeList) {
                        Map<String, Object> tempEdgesMetaMap = new HashMap<>();
                        tempEdgesMetaMap.put("color", "050ff6");
                        tempEdgesMetaMap.put("labelName", edge.getLabelName());
                        edgesMeta.put(edge.getTypeUri(), tempEdgesMetaMap);


                        Map<String, Object> tempEdgesMap = m.convertValue(edge, Map.class);
                        tempEdgesMap.remove("startNode");
                        tempEdgesMap.remove("endNode");
                        tempEdgesMap.remove("properties");

                        JSONObject propertyJsonObject = (JSONObject) JSONObject.parse(edge.getProperties());
                        Map<String, Object> propertyListMap = m.convertValue(propertyJsonObject, Map.class);
                        List<Map> valueList = (List<Map>) propertyListMap.values().stream().findFirst().orElse(Optional.empty());
                        tempEdgesMap.put("propertyList", !ObjectUtils.isEmpty(valueList) ? valueList.get(0).get("propertyList") : Collections.EMPTY_LIST);
                        edges.put(edge.getId(), tempEdgesMap);

                        edgeIds.add(edge.getId());
                    }
                }
            }

            pathMap.put("nodeIds", nodeIds);
            pathMap.put("edgeIds", edgeIds);
            paths.add(pathMap);
        }
        result.put("nodes", nodes);
        result.put("nodesMeta", nodesMeta);
        result.put("edges", edges);
        result.put("edgesMeta", edgesMeta);
        result.put("paths", paths);


        return result;

    }

    private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
        Map<String, Object> result = new HashMap<>(2);
        result.put(key1, value1);
        result.put(key2, value2);
        return result;
    }

}
