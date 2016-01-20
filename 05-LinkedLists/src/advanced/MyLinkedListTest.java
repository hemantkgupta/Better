package advanced;

import java.util.Hashtable;



public class MyLinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ANode head = new ANode();
		head.value = 3;
		
		ANode toAdd = new ANode();
		toAdd.value = 4;
		
		ANode toAdd2 = new ANode();
		toAdd2.value = 5;
		
		ANode toAdd3 = new ANode();
		toAdd3.value = 6;
		
		ANode toAdd4 = new ANode();
		toAdd4.value = 7;
		
		ANode toAdd5 = new ANode();
		toAdd5.value = 8;
		
		ANode toAdd6 = new ANode();
		toAdd6.value = 9;
		
		ANode toAdd7 = new ANode();
		toAdd7.value = 10;
		
		ANode toAdd8 = new ANode();
		toAdd8.value = 11;
		
		
			
		head = insertAtEnd(head, toAdd);
		head = insertAtEnd(head, toAdd2);
		head = insertAtEnd(head, toAdd3);
		head = insertAtEnd(head, toAdd4);
		head = insertAtEnd(head, toAdd5);
		head = insertAtEnd(head, toAdd6);
		head = insertAtEnd(head, toAdd7);
		head = insertAtEnd(head, toAdd8);
		printList(head);
		//head = removeFromGignning(head);
		//printList(head);
		//head = remove(head, toAdd3);
		//printList(head);
		//head = insert(head, toAdd3, toAdd4);
		//printList(head);
		//head = reverse(head);
		//printList(head);
		//head = deleteDupsA(head);
		ANode last = kthToLast(head, 0);
		System.out.println("Last ANode value: "+ last.value);
		System.out.println("Last ANode link: "+ last.next);
		ANode fourth = kthToLast(head, 4);
		System.out.println("Last ANode value: "+ fourth.value);
		System.out.println("Last ANode link: "+ fourth.next);
		last.next = fourth;
		System.out.println(hasCycle2(head));
		
		//kthToLastRecr(head, 2);
		//printList(head);
	}
	
	private static void printList(ANode head) {
		ANode tmp = head;
		System.out.print("List is: ");
		while(tmp != null){
			System.out.print(", "+tmp.value);
			tmp = tmp.next;
		}
		System.out.println();
	}

	public static ANode insertAtBiginning(ANode head, ANode ANode){
		if (head==null){
			return ANode;
		}else {
			ANode.next = head;
			head = ANode;
			return head;
		}
	}
	
	public static ANode removeFromGignning(ANode head){
		if (head.next == null){
			return null;
		}else{
			head = head.next;
			return head;
		}
	}
	
	public static ANode insertAtEnd(ANode head, ANode ANode){
		ANode tmp = head;
		while (tmp.next != null){
			tmp = tmp.next;
		}
		
		tmp.next = ANode;
		
		return head;
	}
	
	public static ANode remove(ANode head, ANode ANode){
		ANode tmp = head;
		if (tmp.value == ANode.value) return head.next;
		
		while (null != tmp.next && tmp.next.value != ANode.value ){
			tmp =tmp.next;
		}
		if (tmp.next == null){
			System.out.println("ANode not found");
			return head;
		}else{
			tmp.next = tmp.next.next;
			return head;
		}
		
	}
	
	public static ANode insert(ANode head, ANode before, ANode ANode){
		
		if (head == before) {
			return insertAtBiginning(head, ANode);
		}
		
		ANode tmp = head ;
		
		while (null != tmp.next && tmp.next.value != before.value){
			tmp = tmp.next;
		}
		
		if(null == tmp.next){
			System.out.println("Before ANode not found");
			return head;
		}	
		else{
			ANode.next = tmp.next.next;
			tmp.next = ANode;
			return head;
		}
		}
	
	public static ANode reverse2(ANode head) {
		ANode first = head;
		ANode reverse = null;
		while (first != null) {
			ANode second = first.next;
			first.next = reverse;
			reverse = first;
			first = second;
		}
		return reverse;
	}
	
	public static ANode reverse(ANode tmp){
		if (tmp == null) return null;
		if (tmp.next == null) return tmp;
		ANode second  = tmp.next;
		ANode rest = reverse(second);
		second.next = tmp;
		tmp.next = null;
		return rest;					
	}
	
	public static ANode deleteDupsA(ANode n) {
		Hashtable table = new Hashtable();
		ANode head = n;
		table.put(n.value, true);
		ANode previous = n;
		n= n.next;
		do  {
			if (table.containsKey(n.value)) {
					previous.next= n.next;
			} else {
				table.put(n.value, true);
				previous = n;
			}
			n = n.next;
		} while (n.next != null);
		return head;
	}

	public static ANode deleteDupsB(ANode head) {
		if (head == null) return null;
		ANode current = head;
		while (current != null) {
			ANode runner = current;
			while (runner.next != null) {
				if(runner.next.value == current.value){
					runner.next = runner.next.next;
				}else{
					runner = runner.next;
				}
			}
			current = current.next;
		}

		return head;
	}
	public static ANode kthToLast (ANode head, int k){
		ANode current = head;
		ANode currentPlusK = head;
		for(int  i=1; i<= k; i++ ){
			currentPlusK = currentPlusK.next;
		}
		while (currentPlusK.next != null){
			current = current.next;
			currentPlusK= currentPlusK.next;
		}
		
		return current;
	}
	public static int kthToLastRecr(ANode head, int k) {
		if (k == 0 || head == null) {
			return 0;
		}
		int calculateK = kthToLastRecr(head.next, k) + 1;
		if (calculateK == k) {
			System.out.println(k + "th to last ANode is " + head.value);
		}
		return calculateK;
	}
	
	public static boolean hasCycle(ANode head){
		if(head == null) return false;
		
		ANode slower = head;
		ANode faster = head.next;
		while (faster != slower){
			slower = slower.next;
			faster = faster.next.next;
			
		}
		
		if(faster == slower){
			return true;
		} else{
			return false;
		}
			
	}
	
	public static boolean hasCycle2(ANode head){
		if(head == null) return false;
		
		ANode turtle = head;
	    ANode hare = head;

	    while ( hare.next != null && hare.next.next != null ) {
	         turtle = turtle.next;
	         hare = hare.next.next;

	         if ( turtle == hare ) return true;
	    }

	    return false;
			
	}
}



class ANode{
	Integer value;
	ANode next;
}
