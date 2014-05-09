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
		root = delete(root, 4);
		printTreeInorder(root);
		
	}
	
	public static Node put(Node root, Integer value){
		 if (root == null) return new Node(value,1);
	        if      (value < root.value) root.left  = put(root.left, value);
	        else if (value > root.value) root.right = put(root.right, value);
	       // else              root.value   = value;
	        root.N = 1 + size(root.left) + size(root.right);
	        return root;
	}
	
	public static Node delete(Node root, Integer value){
		 if (root == null) return null;
	        if      (value < root.value) root.left  = delete(root.left,  value);
	        else if (value > root.value) root.right = delete(root.right, value);
	        else { 
	            if (root.right == null) return root.left;
	            if (root.left  == null) return root.right;
	            Node t = root;
	            root = min(t.right);
	            root.right = deleteMin(t.right);
	            root.left = t.left;
	        } 
	        root.N = size(root.left) + size(root.right) + 1;
	        return root;
	}
	
	public static Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

	
	 public static Node min(Node x) { 
	        if (x.left == null) return x; 
	        else                return min(x.left); 
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
