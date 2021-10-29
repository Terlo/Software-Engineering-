import java.util.ArrayList;

class Node {
    int val;
    Node left;
    Node right;

    Node(int x) {
        val = x;
    }

}

class dagNode {
    int val;
    boolean visited;
    dagNode parent;
    int distance;
    ArrayList<Node> child;

    dagNode(int x) {
        val = x;
    }

}

public class Graph {
    public ArrayList<Node> Nodes; // array of Ndes
    public int nodeCount; // number of verices in the graph

    Graph(int size) {
        nodeCount = size;

    }

    // adds a node to the graph
    void add(dagNode p, dagNode c) {
        // p.child.add(c);
    }

    // returns true if a node is contained in the graph else false
    private Boolean contains() {
        return null;

    }

    // returns true if there exists a path between two nodes else false.
    private Boolean path() {
        return null;

    }

    // returns the euler tour of a graph
    private Node[] eulerTour() {
        return null;

    }

    // returns the range minnimum query which from the euler tour
    private int RMQ() {
        return 0;
    }

    // returns the lowest common ancestor of two Nodes if it exists in the graph
    // the function return null otherwise.
    private Node LCA() {
        return null;
    }

}
