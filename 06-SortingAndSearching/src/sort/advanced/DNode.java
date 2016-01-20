package sort.advanced;

public class DNode {
	int data;
	DNode next;
	DNode prev;

	public DNode(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	@Override
	public String toString() {
		String other = (next == null) ? "" : next.toString();
		return data +" "+ other;
	}

}
