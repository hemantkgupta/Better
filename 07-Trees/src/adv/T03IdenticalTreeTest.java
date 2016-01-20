package adv;

/**
 * Created by hemant on 18/10/15.
 */
public class T03IdenticalTreeTest {

    public static void main(String[] args) {
        BNode root = new BNode(10);
        root.left = new BNode(9);
        root.right = new BNode(8);

        BNode root1 = new BNode(10);
        root1.left = new BNode(9);
        root1.right = new BNode(8);

        System.out.println(identicalTrees(root,root1));

    }

    public static boolean identicalTrees(BNode a, BNode b) {
        if (a == null && b == null)
            return true;

        if (a != null && b != null) {
            return (a.data == b.data &&
                    identicalTrees(a.left, b.left) &&
                    identicalTrees(a.right, b.right));
        }
        return false;
    }
}
