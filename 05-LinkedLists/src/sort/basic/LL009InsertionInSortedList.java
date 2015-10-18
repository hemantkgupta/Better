package sort.basic;

/**
 * Created by hemant on 16/10/15.
 */
public class LL009InsertionInSortedList {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(5);
        root.next.next.next = new Node(6);
        root.next.next.next.next = new Node(7);
        System.out.println(insertInSortedList(root, 4));
    }

    public static Node insertInSortedList(Node root, int data){

        if(root == null ||data < root.data ){
            Node tmp = new Node(data);
            tmp.next = root;
            return tmp;
        }

        Node current = root;
        while(current.next != null && data >= current.next.data){
            current = current.next;
        }
        Node tmpInsert = new Node(data);
        tmpInsert.next = current.next;
        current.next = tmpInsert;
        return root;

    }

}
