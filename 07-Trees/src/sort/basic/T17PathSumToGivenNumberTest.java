package sort.basic;


/**
 * Created by hemant on 17/10/15.
 */
public class T17PathSumToGivenNumberTest {

    public static void main(String[] args) {

        BNode root = new BNode(20);
        root.left = new BNode(8);
        root.left.left = new BNode(4);
        root.left.right = new BNode(12);
        root.left.right.left = new BNode(10);
        root.left.right.right = new BNode(14);
        root.right = new BNode(22);
        root.right.right = new BNode(25);

        System.out.println(hasPathSum(root, 32));
    }

    public static boolean hasPathSum(BNode node, int sum) {
        if (node == null) {
            return (sum == 0);
        } else {
            int subSum = sum - node.data;
            return (hasPathSum(node.left, subSum) || hasPathSum(node.right,
                    subSum));
        }

    }
}
