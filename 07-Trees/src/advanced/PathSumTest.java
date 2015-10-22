package advanced;

public class PathSumTest {

	public static void main(String[] args) {
		BNode root = new BNode(5);
		root.left = new BNode(3);
		root.right = new BNode(9);
		root.left.left = new BNode(1);
		root.left.right = new BNode(4);
		root.right.left = new BNode(6);
		System.out.println(hasPathSum(root,9));
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