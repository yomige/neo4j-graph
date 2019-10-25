package com.graph.repositories;

import com.graph.domain.GraphNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GraphNodeRepository extends Neo4jRepository<GraphNode, String> {

    @Query("MATCH (n:GraphNode {`properties.name`:{name}}) RETURN n")
    List<GraphNode> findByName(@Param("name") String name);

    @Query("MATCH (n1:GraphNode { id: {sourceId} }),(n2:GraphNode { id: {targetId} }), p = shortestPath((n1)-[*]-(n2)) WHERE length(p)> 1 RETURN p")
    List<GraphNode> calculateShortestPath(@Param("sourceId") String sourceId,@Param("targetId") String targetId);
}
