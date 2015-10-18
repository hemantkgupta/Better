package advanced;

public class BuildTreeInLevel {

	public static void main(String[] args) {
		int in[] = { 4, 8, 10, 12, 14, 20, 22 };
		int level[] = { 20, 8, 22, 4, 12, 10, 14 };
		BNode root = buildTree(in, level, 0, in.length - 1, in.length);
		printInorder(root);

	}

	public static BNode buildTree(int[] in, int[] level, int inStrt, int inEnd,
			int n) {

		// If start index is more than the end index
		if (inStrt > inEnd)
			return null;

		/* The first node in level order traversal is root */
		BNode root = new BNode(level[0]);

		/* If this node has no children then return */
		if (inStrt == inEnd)
			return root;

		/* Else find the index of this node in Inorder traversal */
		int inIndex = search2(in, inStrt, inEnd, root.data);

		System.out.println("the inIndex is: "+inIndex);
		// Extract left subtree keys from level order traversal
		int[] llevel = extrackKeys(in, level, inStrt, inIndex);

		// Extract right subtree keys from level order traversal
		int[] rlevel = extrackKeys(in, level, inIndex+1, inEnd);

		/* construct left and right subtress */
		root.left = buildTree(in, llevel, inStrt, inIndex - 1, n);
		root.right = buildTree(in, rlevel, inIndex + 1, inEnd, n);

		return root;
	}

	public static int[] extrackKeys(int[] in, int[] level, int m, int n) {
		int[] newlevel = new int[n-m+1];
		int j = 0;
		for(int i= m ; i<= n;i++){
			int value = search(level, in[i]);
			if ( value != -1) {
				newlevel[j] = value;
				j++;
			}
		}
		return newlevel;
	}

	public static int search(int arr[],int value) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == value)
				return i;
		return -1;
	}
	
	public static int search2(int arr[], int strt, int end, int value)
	{
	    for (int i = strt; i <= end; i++)
	        if (arr[i] == value)
	            return i;
	    return -1;
	}

	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

}
