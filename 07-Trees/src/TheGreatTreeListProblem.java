public class TheGreatTreeListProblem {

	// Demonstrate tree->list with the list 1..5
	public static void main(String[] args) {

		// first build the tree
		// 			4
		// 		2 		5
		// 	1 		3
		BTNode root = new BTNode(4);
		treeInsert(root, 2);
		treeInsert(root, 1);
		treeInsert(root, 3);
		treeInsert(root, 5);

		System.out.println("tree:");
		printTree(root); // 1 2 3 4 5
		System.out.println();

		System.out.println("list:");
		BTNode head = treeToList(root);
		printList(head); // 1 2 3 4 5 yay!
	}

	/*
	 * helper function -- given two list nodes, join them together so the second
	 * immediately follow the first. Sets the .next of the first and the
	 * .previous of the second.
	 */
	public static void join(BTNode a, BTNode b) {
		a.large = b;
		b.small = a;
	}

	/*
	 * helper function -- given two circular doubly linked lists, append them
	 * and return the new list.
	 */
	public static BTNode append(BTNode a, BTNode b) {
		// if either is null, return the other
		if (a == null)
			return (b);
		if (b == null)
			return (a);

		// find the last node in each using the .previous pointer
		BTNode aLast = a.small;
		BTNode bLast = b.small;

		// join the two together to make it connected and circular
		join(aLast, b);
		join(bLast, a);

		return (a);
	}

	/*
	 * --Recursion-- Given an ordered binary tree, recursively change it into a
	 * circular doubly linked list which is returned.
	 */
	public static BTNode treeToList(BTNode root) {
		// base case: empty tree -> empty list
		if (root == null)
			return (null);

		// Recursively do the subtrees (leap of faith!)
		BTNode aList = treeToList(root.small);
		BTNode bList = treeToList(root.large);

		// Make the single root node into a list length-1
		// in preparation for the appending
		root.small = root;
		root.large = root;

		// At this point we have three lists, and it's
		// just a matter of appending them together
		// in the right order (aList, root, bList)
		aList = append(aList, root);
		aList = append(aList, bList);

		return (aList);
	}

	/*
	 * Given a non-empty tree, insert a new node in the proper place. The tree
	 * must be non-empty because Java's lack of reference variables makes that
	 * case and this method messier than they should be.
	 */
	public static void treeInsert(BTNode root, int newData) {
		if (newData <= root.data) {
			if (root.small != null)
				treeInsert(root.small, newData);
			else
				root.small = new BTNode(newData);
		} else {
			if (root.large != null)
				treeInsert(root.large, newData);
			else
				root.large = new BTNode(newData);
		}
	}

	// Do an inorder traversal to print a tree
	// Does not print the ending "\n"
	public static void printTree(BTNode root) {
		if (root == null)
			return;
		printTree(root.small);
		System.out.print(Integer.toString(root.data) + " ");
		printTree(root.large);
	}

	// Do a traversal of the list and print it out
	public static void printList(BTNode head) {
		BTNode current = head;

		while (current != null) {
			System.out.print(Integer.toString(current.data) + " ");
			current = current.large;
			if (current == head)
				break;
		}

		System.out.println();
	}

}

class BTNode {
	int data;
	BTNode small;
	BTNode large;

	public BTNode(int data) {
		this.data = data;
		small = null;
		large = null;
	}
}
