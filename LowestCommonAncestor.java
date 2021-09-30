class Node {
    int val;
    Node left;
    Node right;

    Node(int x) {
        val = x;
    }

}

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        LowestCommonAncestor(a, d, g);

    }

    private static Node result;

    public static Node LowestCommonAncestor(Node root, Node p, Node q) {
        findLCA(root, p, q);
        System.out.println("lOWEST COMMON ANCESTOR FOR NODE " + p.val + " AND NODE " + q.val + " IS " + result.val);
        return result;
    }

    private static boolean findLCA(Node root, Node p, Node q) {
        if (root == null)
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