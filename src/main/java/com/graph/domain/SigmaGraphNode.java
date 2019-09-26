package com.graph.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 前端sigmajs图谱节点对应实体类
 */
@Data
public class SigmaGraphNode {
    private String id;

    private String label;

    private String labelName;

    private String typeUri;

    private Double x;

    private Double y;

    private List<Map<String, Object>> properties;
}
