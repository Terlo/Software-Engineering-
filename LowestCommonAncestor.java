class Node {
    int val;
    Node left;
    Node right;

    Node(int x) {
        val = x;
    }

}

public class LowestCommonAncestor {

    private static Node result;

    public Node LowestCommonAncestor(Node root, Node p, Node q) {
        if (p == null || q == null || root == null) {
            return null;
        }
        findLCA(root, p, q);
        // System.out.println("lOWEST COMMON ANCESTOR FOR NODE " + p.val + " AND NODE "
        // + q.val + " IS " + result.val);
        return result;
    }

    private static boolean findLCA(Node root, Node p, Node q) {
        if (p == null || q == null || root == null)
            return false;
        boolean left = findLCA(root.left, p, q);
        boolean right = findLCA(root.right, p, q);
        boolean current = root == p || root == q;
        if ((left && right) || (left && current) || (right && current)) {
            result = root;
        }
        return left || right || current;

    }
}