package com.aitlp.repositories;

import com.aitlp.domain.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PersonRepository extends Neo4jRepository<Person, Long> {

    @Query("MATCH (n:Person {name:{name}}) RETURN n")
    List<Person> findByName(@Param("name") String name);
}