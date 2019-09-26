package com.graph.domain;

import com.graph.util.Neo4JCustomIdStrategy;
import org.neo4j.ogm.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RelationshipEntity(type = "EDGE")
public class Edge {

    @Id
    @GeneratedValue(strategy = Neo4JCustomIdStrategy.class)
    private String id;

    private String typeUri;

    private String label;

    private String labelName;

    private String type;

    private String source;

    private String target;

    @EndNode
    private GraphNode endNode;

    @StartNode
    private GraphNode startNode;

    private Map<String, Object> properties = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeUri() {
        return typeUri;
    }

    public void setTypeUri(String typeUri) {
        this.typeUri = typeUri;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public GraphNode getEndNode() {
        return endNode;
    }

    public void setEndNode(GraphNode endNode) {
        this.endNode = endNode;
    }

    public GraphNode getStartNode() {
        return startNode;
    }

    public void setStartNode(GraphNode startNode) {
        this.startNode = startNode;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}