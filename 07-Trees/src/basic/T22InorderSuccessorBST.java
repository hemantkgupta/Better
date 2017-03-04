package basic;


public class T22InorderSuccessorBST {

	public static void main(String[] args) {
		BNode root = new BNode(30);
		root.left = new BNode(8);
		root.right = new BNode(35);
		root.right.left = new BNode(32);
		root.right.right = new BNode(36);

		root.left.left = new BNode(4);
		root.left.right = new BNode(12);
		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(14);
		T01TreeTraversalRecursive t = new T01TreeTraversalRecursive();
		t.printInorder(root);
		System.out.println("\nSearching in-order successor for "+ root.right.left.data);
		System.out.println(getInorderSuccessor(root, root.right.left ).data);
	}
	
	public static BNode getInorderSuccessor(BNode root, BNode given){
		
		if(given.right != null){
			return minNode(given.right);
		}
		
		BNode succ = null;
		while(root!= null){
			if (given.data < root.data){
				succ = root;
				root = root.left;
			}else if (given.data > root.data){
				root = root.right;
			}else {
				break;
			}
		}
		
		return succ;	
	}
	
	public static BNode minNode(BNode node){
		BNode current = node;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}
}	
	

