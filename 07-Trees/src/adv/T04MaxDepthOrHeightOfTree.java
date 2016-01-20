package adv;

/**
 * Created by hemant on 18/10/15.
 */
public class T04MaxDepthOrHeightOfTree {

    public static void main(String[] args) {
        BNode root = new BNode(10);
        /* root.left = new BNode(9);
        root.right = new BNode(8);
       root.left.left = new BNode(7);
        root.left.right = new BNode(6);
        root.left.left.left = new BNode(5);
        root.left.right.right = new BNode(4);*/
        System.out.println(maxDepth(root));
    }


    /*
    * Compute the "maxDepth" of a tree -- the number of nodes along the longest
    * path from the root node down to the farthest leaf node.
    */
    public static int maxDepth(BNode node) {
        if (node == null)
            return 0;
        else {
			/* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

			/* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
}
