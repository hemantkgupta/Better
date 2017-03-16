package basic;

/**
 * Created by hemant on 18/10/15.
 */
public class T10CountLeafNodes {

    public static void main(String[] args) {
        BNode root = new BNode(10);
        root.left = new BNode(9);
        root.right = new BNode(8);
        root.left.left = new BNode(7);
        root.left.right = new BNode(6);
        root.left.left.left = new BNode(5);
        root.left.right.right = new BNode(4);
        System.out.println(countLeafNodes(root));
    }

    /* Function to count leaf nodes in a tree */
    public static int countLeafNodes(BNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

}
