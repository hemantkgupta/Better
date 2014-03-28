
public class DiameterBinaryTree {

	public static void main(String[] args) {
		BNode root = new BNode(5);
		root.left = new BNode(3);
		root.right = new BNode(9);
		root.left.left = new BNode(1);
		root.left.right = new BNode(4);
		root.right.left = new BNode(6);
		System.out.println(diameter(root));
	}
	
	/* Function to get diameter of a binary tree */
	public static int diameter(BNode tree)
	{
	   /* base case where tree is empty */
	   if (tree == null)
	     return 0;
	 
	  /* get the height of left and right sub-trees */
	  int lheight = height(tree.left);
	  int rheight = height(tree.right);
	 
	  /* get the diameter of left and right sub-trees */
	  int ldiameter = diameter(tree.left);
	  int rdiameter = diameter(tree.right);
	 
	  return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
	} 
	
	/* Function to calculate height of a tree */
	public static int height(BNode root) {

		if (root == null) {
			return 0;
		}
		int lheight = height(root.left);
		int rheight = height(root.right);
		if (lheight > rheight) {
			return lheight + 1;
		} else
			return rheight + 1;
	}

}
