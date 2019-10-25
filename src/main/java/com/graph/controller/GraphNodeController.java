package com.graph.controller;

import com.graph.domain.GraphNode;
import com.graph.services.GraphNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/graphNode")
public class GraphNodeController {

    @Autowired
    private GraphNodeService graphNodeService;

    @GetMapping("/findByName")
    public List<GraphNode> findByName(String name) {
        return graphNodeService.findByName(name);
    }

    @PostMapping("/save")
    public Map save(@RequestBody String graphNodeJson) {
        return graphNodeService.save(graphNodeJson);
    }

    @GetMapping("/queryGraph")
    public Map<String, Object> queryGraph() {
        return graphNodeService.queryGraph();
    }

    @GetMapping("/calculateShortestPath")
    public Map<String, Object> calculateShortestPath(String sourceId, String targetId) {
        return graphNodeService.calculateShortestPath(sourceId, targetId);
    }


}
