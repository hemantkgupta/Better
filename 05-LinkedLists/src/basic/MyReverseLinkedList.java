package basic;

/**
 * Created by root on 12/12/15.
 */
public class MyReverseLinkedList {

    public static void main(String[] args) {

        Node root = new Node(5);
        Node n1 = new Node(4);
        root.next = n1;
        Node n2 = new Node(3);
        n1.next = n2;
        Node n3 = new Node(2);
        n2.next = n3;
        Node n4 = new Node(1);
        n3.next = n4;

        printList(root);
        root = reverseList(root);
        printList(root);
    }

    public static Node reverseList(Node head){

        Node current = head;
        Node next = null;
        Node prev = null;

		/* reverse first k nodes of the linked list */
        while (current != null) {
            // save the current's next to reference
            // And now make it point to previous
            next = current.next;
            current.next = prev;
            // The new previous is current
            prev = current;
            // The new current is next
            current = next;

        }

        head = prev;
        return head;

    }

    public static void printList(Node root) {
        Node tmp = root;
        System.out.println("The list is: ");
        while (tmp != null) {
            System.out.print(tmp.data + ", ");
            tmp = tmp.next;
        }
        System.out.print("null\n");

    }

}
