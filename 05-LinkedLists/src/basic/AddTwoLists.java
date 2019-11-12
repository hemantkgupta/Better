package basic;

public class AddTwoLists {

    public static void main(String[] args) {
        //System.out.println(Integer.valueOf(String.valueOf(98).substring(0,1)));
        //System.out.println(Integer.valueOf(String.valueOf(98).substring(1)));
        Node l1 = new Node(1);
        //l1.next = new Node(4);
        //l1.next.next = new Node(3);
        Node l2 = new Node (9);
        l2.next = new Node (9);
        //l2.next.next = new Node (4);
        Node sum = addTwoNumbers(l1, l2);
        sum = sum.next;
        System.out.println(sum);
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node result = new Node(0);
        Node current = result;


        int carry = 0;
        while (l1 != null && l2 != null  ){
            Node temp;
            int data1 = l1.data;
            int data2 = l2.data;
            int sum = data1 + data2 + carry;

            if (sum > 9){
                temp = new Node(Integer.valueOf(String.valueOf(sum).substring(1)));
                carry = Integer.valueOf(String.valueOf(sum).substring(0,1));
            } else {
                temp = new Node(sum);
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            //System.out.println("Iteration normal sum "+ temp.data +" and carry is "+ carry);
            current.next = temp;
            current = current.next;
        }
        if (l1 == null){
            while (l2 != null){
                Node temp;
                int data2 = l2.data;
                int sum =  data2 + carry;

                if (sum > 9){
                    temp = new Node(Integer.valueOf(String.valueOf(sum).substring(1)));
                    carry = Integer.valueOf(String.valueOf(sum).substring(0,1));
                } else {
                    temp = new Node(sum);
                    carry = 0;
                }
                l2 = l2.next;
                //System.out.println("Iteration for l2 sum "+ temp.data +" and carry is "+ carry);
                current.next = temp;
                current = current.next;
            }
        }
        if (l1 == null && l2 == null){
            if (carry != 0){
                current.next = new Node(carry);
                current = current.next;
            }
        }

        if (l2 == null){
            while (l1 != null){
                Node temp;
                int data1 = l1.data;
                int sum =  data1 + carry;

                if (sum > 9){
                    temp = new Node(Integer.valueOf(String.valueOf(sum).substring(1)));
                    carry = Integer.valueOf(String.valueOf(sum).substring(0,1));
                } else {
                    temp = new Node(sum);
                    carry = 0;
                }
                l1 = l1.next;
                //System.out.println("Iteration for l1 sum "+ temp.data +" and carry is "+ carry);
                current.next = temp;
                current = current.next;
            }
        }

        return result;

    }
}
