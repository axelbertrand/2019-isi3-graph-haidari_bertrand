package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BFSIterator implements Iterator<Node> {
    IGraph graph;
    Queue<Node> nodeQueue = new ConcurrentLinkedQueue<>();
    List<Node> markedNodes = new ArrayList<>();
    Node currentNode;

    public BFSIterator(IGraph graph, Node root) {
        this.graph = graph;
        nodeQueue.add(root);
        markedNodes.add(root);
    }

    @Override
    public boolean hasNext() {
        return !nodeQueue.isEmpty();
    }

    @Override
    public Node next() {
        currentNode = nodeQueue.remove();
        for(Node adjacentNode : graph.getAdjNodes(currentNode)) {
            if(!markedNodes.contains(adjacentNode)) {
                nodeQueue.add(adjacentNode);
                markedNodes.add(adjacentNode);
            }
        }

        return currentNode;
    }
}
