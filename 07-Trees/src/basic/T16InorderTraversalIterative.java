package basic;


import java.util.ArrayDeque;
import java.util.Deque;


public class T16InorderTraversalIterative {

	public static void main(String[] args) {
		BNode root = new BNode(20);
		root.left = new BNode(9);
		root.right = new BNode(21);
		root.left.left = new BNode(8);
		root.left.right = new BNode(15);
		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(16);
		inorderIter(root);
	}

	/**
	 * We are looking for Left Root Right order in the result so in the stack
	 * we need to put in Right Root Left order.
	 * It gives the idea to first reach the leftmost point of tree and
	 * while traversing save the node.
	 * When tearing down the stack first print the top( Left) then get Right of top to process.
	 * @param root
	 */
	
	public static void inorderIter(BNode root){
		Deque<BNode> stack = new ArrayDeque<BNode>();
		boolean done = false;
		BNode current = root;
		while (!done){
			// Go to leftmost first
			if (current!= null){
				stack.push(current);
				current= current.left;
			}else {
				if  (!stack.isEmpty()){
					current = stack.pop();
					System.out.println(current.data+" ");
					current = current.right;
				}else{
					done = true;
				}
			}		
		}	
	}
}
