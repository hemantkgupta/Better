package adv;

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
	
/*	@Override
	public String toString() {
		String other = (right == null) ? "" : right.toString();
		return data +" "+ other;
	}*/
    @Override
    public String toString() {
        String val = "    "+data+"    "+"\n" + this.left.data+"      "+this.right.data+"\n";
        return val;
    }

}