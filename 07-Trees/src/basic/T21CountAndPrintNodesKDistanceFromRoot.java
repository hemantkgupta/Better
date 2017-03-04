package basic;


public class T21CountAndPrintNodesKDistanceFromRoot {

	public static void main(String[] args) {
		BNode root = new BNode(20);
		root.left = new BNode(8);
		root.right = new BNode(22);

		root.left.left = new BNode(4);
		root.left.right = new BNode(12);
		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(14);
		root.left.left.left = new BNode(80);
		root.left.left.right = new BNode(88);
		System.out.println(countNodesKDistanceFromRoot(root, 3));
		printNodesKdistFromRoot(root, 3);
	} 
	
	public static int countNodesKDistanceFromRoot(BNode root, int k){
		if (root == null)
			return 0;
		if(root!= null && k == 0)
			return 1;
		return countNodesKDistanceFromRoot(root.left, k - 1)+ countNodesKDistanceFromRoot(root.right, k - 1);
	}
	
	public static void printNodesKdistFromRoot(BNode root,int k){
		if (root == null)
			return ;
		if(root!= null && k == 0){
			System.out.println(root.data);
			return;
		}else{
			printNodesKdistFromRoot(root.left, k-1);
			printNodesKdistFromRoot(root.right,k-1);
		}
	}

}
