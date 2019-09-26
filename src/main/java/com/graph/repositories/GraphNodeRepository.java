package com.graph.repositories;

import com.graph.domain.GraphNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GraphNodeRepository extends Neo4jRepository<GraphNode, String> {

    @Query("MATCH (n:GraphNode {`properties.name`:{name}}) RETURN n")
    List<GraphNode> findByName(@Param("name") String name);

    @Query("MATCH (n) RETURN n")
    List<GraphNode> queryGraph();
}
