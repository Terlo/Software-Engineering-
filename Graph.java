
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private static int Nodes;// node count
    private static int Edges;// edge count
    private static ArrayList<Integer>[] children;
    private static int[] indegree;
    private static boolean hasCycle;
    private boolean visited[];
    private boolean stack[];

    Graph(int size) {
        this.Nodes = size;
        this.Edges = 0;
        indegree = new int[Nodes];
        children = (ArrayList<Integer>[]) new ArrayList[size];
        for (int i = 0; i < Nodes; i++) {
            children[Nodes] = new ArrayList<Integer>();
        }
        visited = new boolean[size];
        stack = new boolean[size];

    }

    // adds a node to the graph
    void add(int parent, int child) {
        children[parent].add(child);
        this.Nodes++;
    }

    // returns the euler tour of a digraph, this method is adapted/modified from
    // Hierholzer's algorithm
    // provided by https://www.thecrazyprogrammer.com/
    public static int[] eulerTour(List<List<Integer>> adj) {
        // adj represents the adjacency list of
        // the directed graph
        // edge represents the number of edges emerging from a vertex

        Map<Integer, Integer> edges = new HashMap<Integer, Integer>();

        if (adj.size() < 1) {
            return null;
        }
        for (int i = 0; i < adj.size(); i++) {
            // find the count of edges to keep track of unused edges
            edges.put(i, adj.get(i).size());
        }

        // Maintain a stack to keep vertices
        Stack<Integer> curr_path = new Stack<Integer>();

        // vector to store final circuit
        List<Integer> circuit = new ArrayList<Integer>();
        // result vector
        // We start from vertex 0
        curr_path.push(0);

        // Current vertex
        int curr_v = 0;

        while (!curr_path.empty()) {
            // If there's remaining edge
            if (edges.get(curr_v) > 0) {
                // Push the vertex visited.
                curr_path.push(adj.get(curr_v).get(edges.get(curr_v) - 1));

                // and remove that edge or decrement the edge count.
                edges.put(curr_v, edges.get(curr_v) - 1);

                // Move to next vertex
                curr_v = curr_path.peek();
            }

            // back-track to find remaining circuit
            else {
                circuit.add(curr_path.peek());
                curr_v = curr_path.pop();
            }
        }

        int[] vector = new int[circuit.size()];

        for (int i = 0; i < circuit.size(); i++) {
            vector[i] = circuit.get(i);
        }

        return vector;

    }

    // returns the range minnimum query which from the euler tour
    static int RMQ(int arr[], int lwr, int uppr) {
        if (arr == null || arr.length == 0 || lwr == uppr || lwr < 0 || uppr < 0)
            return -1;
        else if (arr.length == 1) {
            return arr[0];
        }
        int[] tmp = new int[(uppr - lwr) + 1];
        try {
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = arr[i + lwr];
            }
        } catch (Exception e) {
            return -1;
        }
        Arrays.sort(tmp);
        return tmp[0];
    }

    public static int Lowest_Common_Ancestor(List<List<Integer>> adj, int n1, int n2) {
        return RMQ(eulerTour(adj), n1, n2);
    }

}
