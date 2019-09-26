package com.graph.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graph.util.Neo4JCustomIdStrategy;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图谱节点：动态增加属性
 */
@Data
@NodeEntity
public class GraphNode {
    @Id
    @GeneratedValue(strategy = Neo4JCustomIdStrategy.class)
    private String id;

    private String label;

    private String labelName;

    private String typeUri;

    private Double x;

    private Double y;

    @Properties
    private Map<String, Object> properties = new HashMap<>();

    @JsonIgnoreProperties({ "startNode", "endNode" })
    @Relationship(type = "OWNS")
    private List<Edge> edges = new ArrayList<>();
}
