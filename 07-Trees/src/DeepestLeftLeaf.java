
public class DeepestLeftLeaf {

	public static void main(String[] args) {
		BNode root = new BNode(5);
		root.left = new BNode(3);
		root.right = new BNode(9);
		root.left.left = new BNode(1);
		root.left.right = new BNode(4);
		root.right.left = new BNode(6);
		root.right.left.left = new BNode(7);
		deepestLeftLeaf(root, 0, false);
		System.out.println(maxLevel);
		System.out.println(result);
	}
	private static int maxLevel;
	private static BNode result;
	public static void deepestLeftLeaf(BNode root, int level, boolean isLeft){
		if (root == null)
			return ;
		if(isLeft && root.left==null && root.right==null){
			if (level > maxLevel){
				maxLevel = level;
				result = root;
			}
		}
		deepestLeftLeaf(root.left,level+1, true);
		deepestLeftLeaf(root.right,level+1, false);
	}

}
