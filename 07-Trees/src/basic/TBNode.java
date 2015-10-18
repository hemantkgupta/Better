package basic;

/**
 * Created by hemant on 18/10/15.
 */

class TBNode {
    int data;
    TBNode left;
    TBNode right;
    TBNode next;

    public TBNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.next = null;
    }

}