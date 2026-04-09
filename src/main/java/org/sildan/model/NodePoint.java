package org.sildan.model;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;

public record NodePoint(String value) {

    public Edge createEdgeTo(Graph graph, NodePoint node) {
        return graph.addEdge(this.value() + node.value(), this.value(), node.value(), true);
    }

    public Edge createEdgeFrom(Graph graph, NodePoint node) {
        return node.createEdgeTo(graph,this);
    }
}
