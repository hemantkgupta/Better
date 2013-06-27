package com.hkg.test;

public class MyBSTTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node (4, 1);
		root = put(root, 2);
		root = put(root, 6);
		printTreeInorder(root);
		System.out.println(" Size of tree is: "+ size(root));
		
	}
	
	public static Node put(Node root, Integer value){
		 if (root == null) return new Node(value,1);
	        if      (value < root.value) root.left  = put(root.left, value);
	        else if (value > root.value) root.right = put(root.right, value);
	       // else              root.value   = value;
	        root.N = 1 + size(root.left) + size(root.right);
	        return root;
	}
	
	public static int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }
	
	public static void  printTreeInorder(Node root){
		if(root.left != null){
			printTreeInorder(root.left);
		}
		System.out.print(", "+root.value);
		if(root.right != null){
			printTreeInorder(root.right);
		}
	}

}

class Node {
    public Integer value;         // associated data
    public Node left, right;  // left and right subtrees
    public int N;             // number of nodes in subtree

    public Node(Integer value, int N) {
        this.value = value;
        this.N = N;
    }
}
