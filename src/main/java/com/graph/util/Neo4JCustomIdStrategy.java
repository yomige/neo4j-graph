package com.graph.util;

import org.neo4j.ogm.id.IdStrategy;

/**
 * Define entity custom id strategy
 */
public class Neo4JCustomIdStrategy implements IdStrategy {
    @Override
    public Object generateId(Object o) {
        return o.hashCode();
    }

}
