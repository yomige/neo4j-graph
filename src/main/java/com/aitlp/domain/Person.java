package com.aitlp.domain;


import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;


@Data
@NodeEntity
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String gender;
    private String idCard;


    @Relationship(type = "OWN", direction = Relationship.INCOMING)
    private List<House> houses = new ArrayList<>();
}