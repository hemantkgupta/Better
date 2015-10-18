package basic;


public class T22InorderSuccessorBST {

	public static void main(String[] args) {
		BNode root = new BNode(20);
		root.left = new BNode(8);
		root.right = new BNode(22);
		
		root.left.left = new BNode(4);
		root.left.right = new BNode(12);
		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(14);
		System.out.println(getInorderSuccessor(root, root.left.right.left ).data);
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
	

