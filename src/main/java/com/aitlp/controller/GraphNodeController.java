package com.aitlp.controller;

import com.aitlp.domain.GraphNode;
import com.aitlp.services.GraphNodeService;
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
    public Map save(@RequestBody GraphNode graphNode) {
        return graphNodeService.save(graphNode);
    }
}
