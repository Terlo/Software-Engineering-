import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.LowerCaseConversion;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LowestCommonAncestorTest {

    public Node a = new Node(1);
    public Node b = new Node(2);
    public Node c = new Node(3);
    public Node d = new Node(4);
    public Node e = new Node(5);
    public Node f = new Node(6);
    public Node g = new Node(7);
    LowestCommonAncestor lca = new LowestCommonAncestor();

    // test lca when the root node is the common ancestor between the two nodes
    @Test
    public void testRootisLCA() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.left = b;
        a.right = c;

        assertEquals(a, lca.LowestCommonAncestor(a, b, c));

    }

    // test lca function when there exists no LCA between the nodes
    @Test
    public void testNoLCA() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.left = b;
        a.right = c;

        // there is no d node
        assertEquals(null, lca.LowestCommonAncestor(a, b, d));

    }

    // test lca function when the lca is one of the selected nodes
    @Test
    public void testNodeIsLca() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.left = b;
        a.right = c;
        b.left = d;

        // here a is the LCA and also a node
        // System.out.println("the expected data is"+d.val);
        // System.out.println("the returned data"+lca.LowestCommonAncestor(a, b,
        // d).val);
        assertEquals(b, lca.LowestCommonAncestor(a, b, d));
    }

    // test lca when the binary tree is empty
    @Test
    public void testEmptyBinaryTree() {
        Node a = null;
        assertEquals(null, lca.LowestCommonAncestor(a, null, null));

    }

    // DAG tree structure

    // --------1
    // -----2------3
    // ---7-- ----4 5 6

    Graph graph = new Graph(7);

    // test lca when there is no known path between two nodes(therefore there is no
    // LCA)
    @Test
    public void testNoKnownPath() {
        dagNode a = new dagNode(1);
        dagNode b = new dagNode(2);
        Node[] result = graph.DFS(a, b);
        // assertEquals(result, null);
    }

    // test lca function when there exists no path between the nodes
    @Test
    public void testNoLcaDag() {

    }

    // test lca function when the lca is one of the selected nodes
    @Test
    public void testNodeIsLcaDAG() {

    }

}
