package advanced;

import java.util.Arrays;

public class AllInterpretationOfArray {

	public static void main(String args[]) {

		// aacd(1,1,3,4) amd(1,13,4) kcd(11,3,4)
		// Note : 1,1,34 is not valid as we don't have values corresponding
		// to 34 in alphabet
		int[] arr = { 1, 1, 3, 4 };
		printAllInterpretations(arr);

	}

	private static final String[] alphabet = { "", "a", "b", "c", "d", "e",
			"f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
			"s", "t", "u", "v", "w", "x", "v", "z" };

	static void printAllInterpretations(int[] arr) {

		SNode root = createTree(0, "", arr);
		printleaf(root);
		System.out.println();
	}

	// binary tree which stores all interpretations of arr[] in leaves
	public static SNode createTree(int data, String pString, int[] arr) {

		// Invalid input as alphabets maps from 1 to 26
		if (data > 26)
			return null;

		// Parent String + String for this node
		String dataToStr = pString + alphabet[data];

		SNode root = new SNode(dataToStr);

		// if arr.length is 0 means we are done
		if (arr.length != 0) {
			data = arr[0];

			int newArr[] = Arrays.copyOfRange(arr, 1, arr.length);

			root.left = createTree(data, dataToStr, newArr);

			// right child will be null if size of array is 0 or 1
			if (arr.length > 1) {

				data = arr[0] * 10 + arr[1];

				newArr = Arrays.copyOfRange(arr, 2, arr.length);

				root.right = createTree(data, dataToStr, newArr);
			}
		}
		return root;
	}

	// To print out leaf nodes
	public static void printleaf(SNode root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null)
			System.out.print(root.getDataString() + "  ");

		printleaf(root.left);
		printleaf(root.right);
	}

}

class SNode {

	String dataString;
	SNode left;
	SNode right;

	SNode(String dataString) {
		this.dataString = dataString;
		this.left = null;
		this.right = null;
	}

	public String getDataString() {
		return dataString;
	}
}
