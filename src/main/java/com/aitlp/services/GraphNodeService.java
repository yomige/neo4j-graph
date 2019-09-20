package com.aitlp.services;

import com.aitlp.domain.GraphNode;
import com.aitlp.repositories.GraphNodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GraphNodeService {
    private final static Logger LOG = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private GraphNodeRepository graphNodeRepository;

    public List<GraphNode> findByName(String name) {
        return graphNodeRepository.findByName(name);
    }

    @Transactional
    public Map save(GraphNode graphNode) {
        Map resultMap = new HashMap();
        String code = "200";
        String msg = "success";
        try {
            GraphNode node = graphNodeRepository.save(graphNode);
            resultMap.put("data", node);
        } catch (Exception e) {
            code = "500";
            msg = "error";
            e.printStackTrace();
        }
        resultMap.put("code", code);
        resultMap.put("msg", msg);
        return resultMap;
    }
}
