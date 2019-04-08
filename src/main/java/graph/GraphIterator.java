package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class GraphIterator implements Iterator<Node> {
    protected IGraph graph;
    protected Collection<Node> nodeCollection;
    protected List<Node> markedNodes = new ArrayList<>();

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
            if(!markedNodes.contains(adjacentNode)) {
                nodeCollection.add(adjacentNode);
                markedNodes.add(adjacentNode);
            }
        }

        return currentNode;
    }
}
