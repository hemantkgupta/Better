package advanced;

import java.util.Deque;
import java.util.LinkedList;

public class BuildBSTFromPre2 {

	public static void main(String[] args) {
		int pre[] = { 10, 5, 1, 7, 40, 50 };
		BNode root = constructTree(pre);
		printInorder(root);

	}

	// The main function that constructs BST from pre[]
	public static BNode constructTree(int pre[]) {

		int size = pre.length;
		Deque<BNode> stack = new LinkedList<BNode>();
		BNode root = new BNode(pre[0]);
		stack.push(root);

		int i;
		BNode temp;

		// Iterate through rest of the size-1 items of given preorder array
		for (i = 1; i < size; ++i) {
			temp = null;

			// Keep on popping while the next is greater than stack's top

			while (!stack.isEmpty() && pre[i] > stack.peek().data)
				temp = stack.pop();

			// Make this greater value as the right child and push it
			if (temp != null) {
				temp.right = new BNode(pre[i]);
				stack.push(temp.right);
			}

			// If the next value is less than the stack's top value
			// make this as the left child of top node and push
			else {
				stack.peek().left = new BNode(pre[i]);
				stack.push(stack.peek().left);
			}
		}

		return root;
	}

	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

}
