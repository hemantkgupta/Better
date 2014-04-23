
public class RootToLeafPathSum {

	public static void main(String[] args) {
		
		BNode root = new BNode(20);
		root.left = new BNode(9);
		root.right = new BNode(21);
		root.left.left = new BNode(8);
		root.left.right = new BNode(15);
		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(16);
		System.out.println(rootToLeafPathSum(root, 60));

	}
	
	public static boolean rootToLeafPathSum2(BNode root, int sum){
		if (root == null && sum == 0){
			return true;
		} else if (root.left == null && root.right == null && root.data == sum){
			return true;
		}
	    if (root.left!= null){
			if (rootToLeafPathSum (root.left, sum-root.data))
				return true;
	    }
	    if (root.right!= null){
			if (rootToLeafPathSum (root.right, sum-root.data))
				return true;
	    }
		return false;
	}
	
	public static boolean rootToLeafPathSum(BNode root, int sum){
		if (root == null ){
			return sum == 0;
		} else {
			int newSum = sum-root.data;
			return ( rootToLeafPathSum (root.left, newSum) ||
				   rootToLeafPathSum (root.right, newSum) );
		}		
	}

}
