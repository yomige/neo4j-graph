package com.aitlp.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@RelationshipEntity(type = "BELONG_TO")
public class BelongTo {

    @Id
    @GeneratedValue
    private Long id;

    @EndNode
    private Person person;

    @StartNode
    private House house;
}