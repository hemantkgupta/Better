package basic;

public class BinarySearchTree {

    private NodeBST root;

    public void insert(int value) {
        if (root == null) {
            root = new NodeBST(value);
        }
        else {
            root.insert(value);
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }
}
