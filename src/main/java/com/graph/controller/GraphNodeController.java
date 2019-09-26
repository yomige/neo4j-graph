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

    @GetMapping("/findAll")
    public Map<String, Object> findAll() {
        return graphNodeService.findAll();
    }

}
