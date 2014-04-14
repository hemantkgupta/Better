import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoBST {

	public static void main(String[] args) {
		BNode root1 = new BNode(100);
		root1.left = new BNode(50);
		root1.right = new BNode(300);
		root1.left.left = new BNode(20);
		root1.left.right = new BNode(70);

		BNode root2 = new BNode(80);
		root2.left = new BNode(40);
		root2.right = new BNode(120);
		BNode root = mergeTrees(root1, root2, 5, 3);
		printInorder(root);

	}

	public static BNode mergeTrees(BNode root1, BNode root2, int m, int n) {
		Integer[] arr1 = new Integer[m];
		List<Integer> first = new ArrayList<Integer>();
		storeInorder(root1, first);
		arr1 = first.toArray(arr1);
		System.out.println(Arrays.toString(arr1));
		first.clear();
		Integer[] arr2 = new Integer[n];
		storeInorder(root2, first);
		arr2 = first.toArray(arr2);
		System.out.println(Arrays.toString(arr2));

		int[] mergedArr = merge(arr1, arr2, m, n);
		return sortedArrayToBST(mergedArr, 0, m + n - 1);
	}

	public static BNode sortedArrayToBST(int arr[], int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		BNode root = new BNode(arr[mid]);
		root.left = sortedArrayToBST(arr, start, mid - 1);
		root.right = sortedArrayToBST(arr, mid + 1, end);
		return root;
	}

	public static void storeInorder(BNode node, List<Integer> list) {
		if (node == null)
			return;
		storeInorder(node.left, list);
		list.add(node.data);
		storeInorder(node.right, list);
	}

	public static int[] merge(Integer arr1[], Integer arr2[], int m, int n) {
		int[] mergedArr = new int[m + n];
		int i = 0, j = 0, k = 0;
		while (i < m && j < n) {
			if (arr1[i] < arr2[j]) {
				mergedArr[k] = arr1[i];
				i++;
			} else {
				mergedArr[k] = arr2[j];
				j++;
			}
			k++;
		}
		while (i < m) {
			mergedArr[k] = arr1[i];
			i++;
			k++;
		}
		while (j < n) {
			mergedArr[k] = arr2[j];
			j++;
			k++;
		}
		return mergedArr;
	}

	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

}
