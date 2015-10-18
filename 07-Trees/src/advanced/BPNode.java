package advanced;

/**
 * Created by hemant on 17/10/15.
 */
public class BPNode {

    int data;
    BPNode left;
    BPNode right;
    BPNode parent;

    public BPNode(int data) {
        super();
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    @Override
    public String toString() {
        String other = (right == null) ? "" : right.toString();
        return data +" "+ other;
    }

}