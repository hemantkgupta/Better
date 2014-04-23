
public class AVLTree2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ABNode leftRotate (ABNode y){
		ABNode x = y.right;
		ABNode T2 = x.left;		
		x.left = y;
		y.right = T2;
		
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		
		return x;
	}
	
	public static ABNode rightRotate (ABNode y){
		ABNode x = y.left;
		ABNode T2 = x.right;
		x.right = y;
		y.left = T2;
		
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		
		return x;
	}
	
	// A utility function to get height of the tree
		public static int height(ABNode N) {
			if (N == null)
				return 0;
			return N.height;
		}

}
