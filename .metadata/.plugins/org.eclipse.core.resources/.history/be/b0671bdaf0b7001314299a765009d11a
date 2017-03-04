package com.hkg.test;

import java.util.Hashtable;



public class MyLinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = new Node();
		head.value = 3;
		
		Node toAdd = new Node();
		toAdd.value = 4;
		
		Node toAdd2 = new Node();
		toAdd2.value = 5;
		
		Node toAdd3 = new Node();
		toAdd3.value = 6;
		
		Node toAdd4 = new Node();
		toAdd4.value = 7;
		
		Node toAdd5 = new Node();
		toAdd5.value = 8;
		
		Node toAdd6 = new Node();
		toAdd6.value = 9;
		
		Node toAdd7 = new Node();
		toAdd7.value = 10;
		
		Node toAdd8 = new Node();
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
		Node last = kthToLast(head, 0);
		System.out.println("Last node value: "+ last.value);
		System.out.println("Last node link: "+ last.next);
		Node fourth = kthToLast(head, 4);
		System.out.println("Last node value: "+ fourth.value);
		System.out.println("Last node link: "+ fourth.next);
		last.next = fourth;
		System.out.println(hasCycle2(head));
		
		//kthToLastRecr(head, 2);
		//printList(head);
	}
	
	private static void printList(Node head) {
		Node tmp = head;
		System.out.print("List is: ");
		while(tmp != null){
			System.out.print(", "+tmp.value);
			tmp = tmp.next;
		}
		System.out.println();
	}

	public static Node insertAtBiginning(Node head, Node node){
		if (head==null){
			return node;
		}else {
			node.next = head;
			head = node;
			return head;
		}
	}
	
	public static Node removeFromGignning(Node head){
		if (head.next == null){
			return null;
		}else{
			head = head.next;
			return head;
		}
	}
	
	public static Node insertAtEnd(Node head, Node node){
		Node tmp = head;
		while (tmp.next != null){
			tmp = tmp.next;
		}
		
		tmp.next = node;
		
		return head;
	}
	
	public static Node remove(Node head, Node node){
		Node tmp = head;
		if (tmp.value == node.value) return head.next;
		
		while (null != tmp.next && tmp.next.value != node.value ){
			tmp =tmp.next;
		}
		if (tmp.next == null){
			System.out.println("Node not found");
			return head;
		}else{
			tmp.next = tmp.next.next;
			return head;
		}
		
	}
	
	public static Node insert(Node head, Node before, Node node){
		
		if (head == before) {
			return insertAtBiginning(head, node);
		}
		
		Node tmp = head ;
		
		while (null != tmp.next && tmp.next.value != before.value){
			tmp = tmp.next;
		}
		
		if(null == tmp.next){
			System.out.println("Before node not found");
			return head;
		}	
		else{
			node.next = tmp.next.next;
			tmp.next = node;
			return head;
		}
		}
	
	public static Node reverse2(Node head) {
		Node first = head;
		Node reverse = null;
		while (first != null) {
			Node second = first.next;
			first.next = reverse;
			reverse = first;
			first = second;
		}
		return reverse;
	}
	
	public static Node reverse(Node tmp){
		if (tmp == null) return null;
		if (tmp.next == null) return tmp;
		Node second  = tmp.next;
		Node rest = reverse(second);
		second.next = tmp;
		tmp.next = null;
		return rest;					
	}
	
	public static Node deleteDupsA(Node n) {
		Hashtable table = new Hashtable();
		Node head = n;
		table.put(n.value, true);
		Node previous = n;
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

	public static Node deleteDupsB(Node head) {
		if (head == null) return null;
		Node current = head;
		while (current != null) {
			Node runner = current;
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
	public static Node kthToLast (Node head, int k){
		Node current = head;
		Node currentPlusK = head;
		for(int  i=1; i<= k; i++ ){
			currentPlusK = currentPlusK.next;
		}
		while (currentPlusK.next != null){
			current = current.next;
			currentPlusK= currentPlusK.next;
		}
		
		return current;
	}
	public static int kthToLastRecr(Node head, int k) {
		if (k == 0 || head == null) {
			return 0;
		}
		int calculateK = kthToLastRecr(head.next, k) + 1;
		if (calculateK == k) {
			System.out.println(k + "th to last node is " + head.value);
		}
		return calculateK;
	}
	
	public static boolean hasCycle(Node head){
		if(head == null) return false;
		
		Node slower = head;
		Node faster = head.next;
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
	
	public static boolean hasCycle2(Node head){
		if(head == null) return false;
		
		Node turtle = head;
	    Node hare = head;

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
