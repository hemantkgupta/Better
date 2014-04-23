
public class BuildSpecialTreeFromInorder {

	public static void main(String[] args) {
		//int[] in = {1, 5, 10, 40, 30, 15, 28, 20};
		int[] in = {5, 10, 40, 30, 28};
		BNode root = null;
		root = build(root, in, 0, in.length-1);
		printInorder(root);
	}
	
	public static BNode build(BNode root, int[] in, int start, int end){
		
		if(start > end)
		     return null;		
		int maxIndex = indexOfMax(in, start, end);
		root = new BNode(in[maxIndex]);
		if(maxIndex == start && start== end){
			return root;
		}
		root.left = build(root.left, in, start,maxIndex-1 );
		root.right = build(root.right, in, maxIndex+1, end );
		
		return root;
	}
	
	public static int indexOfMax(int[] in, int start, int end){
		int max = start;
		for (int i = start+1; i <= end; i++) {
			if (in[i] > in[max]){
				max = i;
			}
		}
		return max;	
	}
	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

}