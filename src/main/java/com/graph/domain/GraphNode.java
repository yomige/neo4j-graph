package com.graph.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.graph.util.Neo4JCustomIdStrategy;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图谱节点：动态增加属性
 */
@NodeEntity
public class GraphNode {
    @Id
    @GeneratedValue(strategy = Neo4JCustomIdStrategy.class)
    private String id;

    private String caseId;

    private String color = "#7076ed";

    private String label;

    private String labelName;

    private String typeUri;

    private Double x;

    private Double y;

    private boolean active;

    @Properties
    private Map<String, Object> icon = new HashMap<>();

    private String properties;

    @JsonIgnoreProperties({"startNode", "endNode"})
    @Relationship(type = "EDGE")
    private List<Edge> edges = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getTypeUri() {
        return typeUri;
    }

    public void setTypeUri(String typeUri) {
        this.typeUri = typeUri;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Map<String, Object> getIcon() {
        return icon;
    }

    public void setIcon(Map<String, Object> icon) {
        this.icon = icon;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
