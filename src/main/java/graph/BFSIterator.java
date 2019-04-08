package graph;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BFSIterator extends GraphIterator {
    public BFSIterator(IGraph graph, Node root) {
        super(graph, root);
    }

    @Override
    protected Collection<Node> createNodeCollection() {
        return new ConcurrentLinkedQueue<>();
    }

    @Override
    protected Node getAndRemoveLastElement() {
        return ((ConcurrentLinkedQueue<Node>) nodeCollection).remove();
    }
}
