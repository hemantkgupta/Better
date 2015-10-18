package advanced;

public class AddAllGreaterBST {

	public static void main(String[] args) {
		BNode root = new BNode(50);

		root.left = new BNode(30);
		root.right = new BNode(70);

		root.left.left = new BNode(20);
		root.left.right = new BNode(40);

		root.right.left = new BNode(60);
		root.right.right = new BNode(80);
		System.out.println("Before");
		printInorder(root);
		modifyBST(root);
		System.out.println("\nAfter");
		printInorder(root);
	}

	public static int sum;

	// Recursive function to add all greater values in every node
	public static void modifyBST(BNode root) {
		if (root == null)
			return;

		modifyBST(root.right);
		
		sum = sum + root.data;
		root.data = sum;

		modifyBST(root.left);
	}

	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

}
