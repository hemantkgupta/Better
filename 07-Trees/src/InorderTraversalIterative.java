import java.util.ArrayDeque;
import java.util.Deque;


public class InorderTraversalIterative {

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
	
	
	
	public static void inorderIter(BNode root){
		Deque<BNode> stack = new ArrayDeque<BNode>();
		boolean done = false;
		BNode current = root;
		while (!done){
			
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
