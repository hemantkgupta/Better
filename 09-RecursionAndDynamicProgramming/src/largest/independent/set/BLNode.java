package largest.independent.set;

class BLNode {
	int data;
	int liss;
	BNode left;
	BNode right;

	public BLNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.liss = 0;
	}

}