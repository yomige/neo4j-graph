package com.graph.repositories;

import com.graph.domain.Edge;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface GraphEdgeRepository extends Neo4jRepository<Edge, String> {
}
