import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.LowerCaseConversion;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DAGtest {

    @Test
    public void testEulerTour() {
        // testing an empty graph for a euler tour
        List<List<Integer>> empty_g = new ArrayList<>();
        assertEquals("Testing the eulerian trail for an empty graph g.", null, Graph.eulerTour(empty_g));

        // testing a graph with one node for a euler tour
        List<List<Integer>> one_node_g = new ArrayList<>();
        assertEquals("Testing the eulerian trail for a graph with one node.", null, Graph.eulerTour(one_node_g));
        one_node_g.add(new ArrayList<Integer>());
        one_node_g.get(0).add(1);
        int[] a1 = { 1, 2, 3, 4, 5, 6 };
        assertEquals("Testing the eulerian trail for graph g.", a1, Graph.eulerTour(one_node_g));

        // testing a euler tour for a graph with more than one node
        List<List<Integer>> g = new ArrayList<>();
        g.add(new ArrayList<Integer>());
        g.get(0).add(1);
        g.add(new ArrayList<Integer>());
        g.get(1).add(2);
        g.add(new ArrayList<Integer>());
        g.get(2).add(3);
        g.add(new ArrayList<Integer>());
        g.get(3).add(0);
        g.add(new ArrayList<Integer>());
        g.get(4).add(3);
        int[] array = { 1, 2, 3, 4, 5, 6 };
        assertEquals("Testing the eulerian trail for graph g with more than one node.", array, Graph.eulerTour(g));

    }

    // test range minimum query function (used to determine LCA from euler tour)
    @Test
    public void testRMQ() {
        // test the case where the are no values in the range
        int[] a1 = {};
        assertEquals(Graph.RMQ(a1, 1, 6), 1);
        // test the case where the are is only one element in the range
        int[] a2 = { 6 };
        assertEquals(Graph.RMQ(a2, 0, 0), 6);
        // test the case 1 is the rmq
        int[] a3 = { 1, 2, 3, 4, 5, 6 };
        assertEquals(Graph.RMQ(a3, 1, 6), 1);
        // testing the case:invalid lower bound.
        int[] a4 = { 1, 2, 3, 4, 5, 6 };
        assertEquals(Graph.RMQ(a4, -3, 6), -1);
        // testing the case:invalid upper bound.
        int[] a5 = { 1, 2, 3, 4, 5, 6 };
        assertEquals(Graph.RMQ(a5, 1, -6), -1);

    }

    // test lca function when the lca is one of the selected nodes
    @Test
    public void testLowestCommonAncestor() {
        List<List<Integer>> g = new ArrayList<>();
        g.add(new ArrayList<Integer>());
        g.get(0).add(1);
        g.add(new ArrayList<Integer>());
        g.get(1).add(2);
        // g.get(1).add(4);
        g.add(new ArrayList<Integer>());
        g.get(2).add(3);
        g.add(new ArrayList<Integer>());
        g.get(3).add(0);
        // g.get(3).add(1);
        g.add(new ArrayList<Integer>());
        g.get(4).add(3);
        int lca = Graph.Lowest_Common_Ancestor(g, 1, 2);
        assertEquals("Testing the case: lca is one of the selected nodes", lca, 2);

        List<List<Integer>> g1 = new ArrayList<>();
        g1.add(new ArrayList<Integer>());
        g1.get(0).add(1);
        g1.add(new ArrayList<Integer>());
        g1.get(1).add(2);
        g1.add(new ArrayList<Integer>());
        g1.add(new ArrayList<Integer>());
        g1.get(3).add(2);
        g1.add(new ArrayList<Integer>());
        g1.get(4).add(3);
        lca = Graph.Lowest_Common_Ancestor(g, 0, 4);
        assertEquals("Testing the case: lca is NO common ancestor to the selected nodes", lca, -1);

        List<List<Integer>> g2 = new ArrayList<>();
        lca = Graph.Lowest_Common_Ancestor(g2, 0, 5);
        assertEquals("Testing the case: the graph is empty", lca, -1);

        lca = Graph.Lowest_Common_Ancestor(g, 0, 100);
        assertEquals("Testing the case: the graph is not empty but one of the selected nodes doesn't exist.", lca, -1);
    }

}