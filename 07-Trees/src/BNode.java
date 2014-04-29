class BNode {
	int data;
	BNode left;
	BNode right;

	public BNode(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public String toString() {
		String other = (right == null) ? "" : right.toString();
		return data +" "+ other;
	}

}