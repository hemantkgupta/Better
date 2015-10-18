package sort.advanced;

public class ABNode {
	int key;
	ABNode left;
	ABNode right;
	int height;
	int size;

	public ABNode(int data) {
		super();
		this.key = data;
		this.left = null;
		this.right = null;
		this.height = 1;
		this.size = 1;
	}
}
