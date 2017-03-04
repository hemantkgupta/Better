package basic;

/**
 * Created by hemant on 18/10/15.
 */
public class T01TreeTraversalRecursive {

    public static void main(String[] args) {
        BNode root = new BNode(10);
        root.left = new BNode(9);
        root.right = new BNode(8);
        root.left.left = new BNode(7);
        root.left.right = new BNode(6);
        root.left.left.left = new BNode(5);
        root.left.right.right = new BNode(4);
        printPostorder(root);
        printInorder(root);
        printPreorder(root);
    }

    public static void printPostorder(BNode node) {
        if (node == null)
            return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.format("%d ", node.data);
    }

    public static void printInorder(BNode node) {
        if (node == null)
            return;

        printInorder(node.left);
        System.out.format("%d ", node.data);
        printInorder(node.right);
    }

    public static void printPreorder(BNode node) {
        if (node == null)
            return;

        System.out.format("%d ", node.data);
        printPreorder(node.left);
        printPreorder(node.right);

    }

}
