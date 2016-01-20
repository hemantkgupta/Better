package adv;



public class T19WidthOfTree {

	public static void main(String[] args) {
		BNode root = new BNode(1);
		root.left = new BNode(2);
		root.right = new BNode(3);
		root.left.left = new BNode(4);
		root.left.right = new BNode(5);
		root.right.right = new BNode(8);
		root.right.right.left = new BNode(6);
		root.right.right.right = new BNode(7);
		System.out.println(widthOfTree(root));
	}
	
	
	
	public static int widthOfTree(BNode root){
		
		 int h = height(root);
		 int maxWidth = 0; 
		 for (int i = 1; i <= h; i++){
			 int width = widthOfGivenLevel(root, i);
			 if(width > maxWidth){
				 maxWidth=width;
			 }
		 }
		return maxWidth ;
	}

	private static int widthOfGivenLevel(BNode root, int level) {
		
		if (root == null)
			return 0;
		if (level == 1)
			return 1;
		
		return widthOfGivenLevel(root.left, level - 1)+
				widthOfGivenLevel(root.right, level - 1);		
		
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
