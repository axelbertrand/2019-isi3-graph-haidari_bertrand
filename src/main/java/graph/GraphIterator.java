package graph;

import java.util.*;

public abstract class GraphIterator implements Iterator<Node> {
    protected IGraph graph;
    protected Collection<Node> nodeCollection;
    protected Set<Node> markedNodes = new HashSet<>();

    public GraphIterator(IGraph graph, Node root) {
        this.graph = graph;
        nodeCollection = createNodeCollection();
        nodeCollection.add(root);
        markedNodes.add(root);
    }

    protected abstract Collection<Node> createNodeCollection();

    protected abstract Node getAndRemoveLastElement();

    @Override
    public boolean hasNext() {
        return !nodeCollection.isEmpty();
    }

    @Override
    public Node next() {
        Node currentNode = this.getAndRemoveLastElement();
        for(Node adjacentNode : graph.getAdjNodes(currentNode)) {
            if(markedNodes.add(adjacentNode)) {
                nodeCollection.add(adjacentNode);
            }
        }

        return currentNode;
    }
}
