package advanced;


import basic.*;

import java.util.Deque;
import java.util.LinkedList;

public class T029KthSmallestBST {

	public static void main(String[] args) {
		basic.BNode root = new basic.BNode(20);
		root.left = new basic.BNode(8);
		root.right = new basic.BNode(22);
		root.left.left = new basic.BNode(4);
		root.left.right = new basic.BNode(12);
		root.left.right.left = new basic.BNode(10);
		root.left.right.right = new basic.BNode(14);
		root = kthSmallest(root, 1);
		System.out.println(root.data);
	}

	public static basic.BNode kthSmallest(basic.BNode root, int k) {
		Deque<basic.BNode> st = new LinkedList<basic.BNode>();
		basic.BNode pCrawl = root;

		while (pCrawl != null) {
			st.push(pCrawl);
			pCrawl = pCrawl.left;
		}

		/* pop off stack and process each node */
		while ((pCrawl = st.pop()) != null) {

			--k;
			if (k == 0) {
				break;
			}

			/* there is right subtree */
			if (pCrawl.right != null) {
				/* push the left subtree of right subtree */
				pCrawl = pCrawl.right;
				while (pCrawl != null) {
					st.push(pCrawl);
					pCrawl = pCrawl.left;
				}
			}
		}
		return pCrawl;
	}

	public static void printInorder(basic.BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

}
