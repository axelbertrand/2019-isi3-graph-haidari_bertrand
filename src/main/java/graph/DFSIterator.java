package graph;

import java.util.Collection;
import java.util.Stack;

public class DFSIterator extends GraphIterator {
    public DFSIterator(IGraph graph, Node root) {
        super(graph, root);
    }

    @Override
    protected Collection<Node> createNodeCollection() {
        return new Stack<>();
    }

    @Override
    protected Node getAndRemoveLastElement() {
        return ((Stack<Node>) nodeCollection).pop();
    }
}
