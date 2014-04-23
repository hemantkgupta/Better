import java.util.ArrayDeque;
import java.util.Queue;


public class LevelOrderTraversalUsingQ {

	public static void main(String[] args) {
		BNode root = new BNode(10);
		root.left = new BNode(9);
		root.right = new BNode(2);
		root.left.left = new BNode(7);
		root.left.right = new BNode(6);
		root.left.left.left = new BNode(5);
		root.left.right.right = new BNode(4);
		levelOrderTraversal(root);

	}
	
	public static void levelOrderTraversal(BNode root){
		Queue<BNode> queue =  new ArrayDeque<BNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			BNode temp = queue.remove();
			System.out.println(temp.data+" ");
			if(temp.left!= null)
				queue.add(temp.left);
			if(temp.right!= null)
				queue.add(temp.right);
			
		}
	}

}
