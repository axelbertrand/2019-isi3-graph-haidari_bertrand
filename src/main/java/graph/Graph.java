package graph;

import java.util.*;

import static java.util.stream.Collectors.joining;


public class Graph implements IDirectedGraph {

    /**
     * A chaque cle=noeud est associe la liste des arcs sortants de ce noeud
     */
    private Map<Node, List<Arc>> adjacence;

    public Graph() {
        adjacence = new HashMap<>();
    }

    /**
     * @param _n1
     * @param _n2
     * @return vrai si graph possede arc de src _n1 et destination _n2
     */
    public boolean hasArc(Node _n1, Node _n2) {
        List<Arc> arretesAdj = adjacence.get(_n1);
        for (Arc _a : arretesAdj) {
            if (_n1.equals(_a.getSource()) && _n2.equals(_a.getDestination())) {
                return true;
            }
        }

        return false;
    }

    public void addNode(Node _node) {
        adjacence.put(_node, new ArrayList<>());
    }

    public void addArc(Arc _edge) {
        if (!hasArc(_edge.getSource(), _edge.getDestination())) {
            adjacence.get(_edge.getSource()).add(_edge);
        }
    }

    public List<Node> getAllNodes() {
        return new ArrayList<>(adjacence.keySet());
    }

    public int getNbNodes() {
        return adjacence.size();
    }

    /**
     * @param _n
     * @return tous les arcs de source _n
     */
    public List<Arc> getArc(Node _n) {
        return adjacence.get(_n);
    }

    /**
     * renvoie tous les noeuds qui sont destination d'un arc dont la source est _n
     */
    public List<Node> getAdjNodes(Node _n) {
        //A COMPLETER
        if (!adjacence.containsKey(_n)) {
            return null;
        }

        List<Node> listNode = new ArrayList<>();
        for (Arc arc : adjacence.get(_n)) {
            if (arc.getSource().equals(_n)) {
                listNode.add(arc.getDestination());
            }
        }

        return listNode;
    }

    @Override
    public Iterator<Node> creerBFSIterator(Node n) {
        return new BFSIterator(this, n);
    }

    @Override
    public Iterator<Node> creerDFSIterator(Node n) {
        return new DFSIterator(this, n);
    }


    @Override
    public String toString() {
        //A COMPLETER

        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("Graph \n");
        for (Node node : adjacence.keySet()) {
            sBuilder.append("[noeud = " + node + " : [");
            String stringifiedArcs = getArc(node).stream().map(Object::toString).collect(joining(", "));
            sBuilder.append(stringifiedArcs + "] \n");
        }

        return sBuilder.toString();
    }
}
