package com.aitlp.domain;

import com.aitlp.util.Neo4JCustomIdStrategy;
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

    @Properties
    private Map<String, Object> properties = new HashMap<>();

    @Relationship(type = "BELONG_TO", direction = Relationship.INCOMING)
    private List<House> houses = new ArrayList<>();
}
