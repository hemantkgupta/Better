package basic;

public class T00BinarySearchTree {

    public static void main(String[] args) {


        BinarySearchTree intTree = new BinarySearchTree();

        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);


        intTree.traverseInOrder();

    }
}
