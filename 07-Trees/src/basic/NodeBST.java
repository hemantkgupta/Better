package basic;

public class NodeBST {

    private int data;
    private NodeBST leftChild;
    private NodeBST rightChild;

    public void insert(int value) {
        if (value == data) {
            return;
        }

        if (value < data) {
            if (leftChild == null) {
                leftChild = new NodeBST(value);
            }
            else {
                leftChild.insert(value);
            }
        }
        else {
            if (rightChild == null) {
                rightChild = new NodeBST(value);
            }
            else {
                rightChild.insert(value);
            }
        }
    }

    public void traverseInOrder() {
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.print(data + ", ");
        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    public NodeBST(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeBST getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeBST leftChild) {
        this.leftChild = leftChild;
    }

    public NodeBST getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeBST rightChild) {
        this.rightChild = rightChild;
    }

}
