package basic;

import advanced.*;

public class T27BalancedBSTFromSortedArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		advanced.BNode root = sortedArrayToBST(arr, 0, arr.length-1);
		printInorder(root);
		
	}

	public static advanced.BNode sortedArrayToBST(int arr[], int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		advanced.BNode root = new advanced.BNode(arr[mid]);
		root.left = sortedArrayToBST(arr, start, mid - 1);
		root.right = sortedArrayToBST(arr, mid + 1, end);
		return root;
	}

	public static void printInorder(advanced.BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

}
