package adv;

/**
 * Created by hemant on 18/10/15.
 */
public class T02SizeOfTree {

    public static void main(String[] args) {
        BNode root = new BNode(10);
        root.left = new BNode(9);
        root.right = new BNode(8);
        root.left.left = new BNode(7);
        root.left.right = new BNode(6);
        root.left.left.left = new BNode(5);
        root.left.right.right = new BNode(4);
        System.out.println(size(root));
    }

    /*
	 Compute the number of nodes in a tree.
	*/
    public static int size(BNode node) {
        if (node == null)
            return 0;
        else
            return (size(node.left) + 1 + size(node.right));
    }
}
