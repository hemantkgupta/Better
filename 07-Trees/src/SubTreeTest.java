
public class SubTreeTest {

	public static void main(String[] args) {
		
		BNode tree1 = new BNode(26);
		tree1.left = new BNode(10);
		tree1.right = new BNode(3);
		
		tree1.left.left = new BNode(4);
		tree1.left.right = new BNode(6);
		tree1.right.right = new BNode(3);

		tree1.left.left.right = new BNode(30);
		
		BNode tree2 = new BNode(10);
		tree2.left = new BNode(4);
		tree2.right = new BNode(6);
		tree2.left.right = new BNode(30);
		
		System.out.println(subtree(tree1, tree2));
		

	}
	
	public static boolean subtree(BNode tree1, BNode tree2) {
		if (tree2 == null)
			return true;		
		if (tree1 == null )
			return false;
		if (identicalTrees(tree1, tree2))
			return true;
		return  subtree(tree1.left, tree2) || subtree(tree1.right, tree2);
		
	}	
	public static boolean identicalTrees(BNode a, BNode b) {
		if (a == null && b == null)
			return true;
		if (a != null && b != null) {
			return (a.data == b.data &&
					identicalTrees(a.left, b.left) &&
					identicalTrees(a.right, b.right));
		}
		return false;
	}


}
