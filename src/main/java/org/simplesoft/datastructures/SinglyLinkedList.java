package org.simplesoft.datastructures;

import java.util.Random;

public class SinglyLinkedList<T extends Comparable<T>> {

	private Node head;
	private Node tail;
	private int size;
	
	public SinglyLinkedList() {
		this.head = this.tail = null;
	}
	
	public int size() {
		return size;
	}
	
	public void add(T element) {
		Node node = new Node(element);
		
		if(tail == null && head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		
		size++;
	}

	public T remove(T element) {
		
		Node parent = null;
		Node node = head;
		while (node != null) {
			if (element.equals(node.value)) {
				if(parent != null) {
					parent.next = node.next;
				}
				else {
					head = node.next;
				}
				
				return node.value;
			}
			else {
				parent = node;
				node = node.next;
			}
		}
		return null;
	}
	
	public boolean contains(T element) {

		Node node = head;
		while (node != null) {
			if (element.equals(node.value)) {
				return true;
			}
			node=node.next;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder buff = new StringBuilder();
		Node node = head;
		buff.append('[');
		while (node != null) {
			buff.append(node.value).append(",");
			node=node.next;
		}
		
		if( buff.charAt(buff.length()-1) == ',' ) {
			buff.deleteCharAt(buff.length()-1);
		}
		
		buff.append(']');
		
		return buff.toString();
	}
	
	private class Node {
	
		Node next;
		T value;
		
		public Node(T value) {
			this.value = value;
			this.next = null;
		}
	}

	
	public void sort() {
		head = mergeSort(head);
	}
	
	private Node mergeSort(Node head) {
		
		// single element
		if(head.next == null) {
			return head;
		}
		
		// two element array
		if(head.next != null && head.next.next == null) {
			if(head.value.compareTo(head.next.value) > 0) {
				// swap the nodes
				Node tail = head;
				head = head.next;
				head.next = tail;
				tail.next = null;
			}
		}
		
		// for list.size > 2, split:
		Node head1 = head;
		Node middle = getMiddle(head);
		Node head2 = middle.next;
		
		// now split the list by severing 
		// the link
		middle.next = null;
		
		head1 = mergeSort(head1);
		head2 = mergeSort(head2);
		
//		long x = System.currentTimeMillis();
//		System.out.println("[BEGIN: mergeSortedLists]" + System.currentTimeMillis());
		head = mergeSortedLists(head1, head2);
//		System.out.println("[took: mergeSortedLists]" + (System.currentTimeMillis() - x));
		return head;
	}
	
	private Node mergeSortedLists(Node head1, Node head2) {
		
//		System.out.println("[mergeSortedLists]: \n\t" + str(head1) + "\n\t" + str(head2));
		
		if (head1 == null ) {
			return head2;
		}
		
		if(head2 == null) {
			return head1;
		}
		
		Node mergedListHead = null;
		Node mergedListTail = null;
		while(head1 != null && head2 != null ){
			if (head1.value.compareTo(head2.value) < 0) {
				if(mergedListHead != null) {
					mergedListTail.next = head1;
					mergedListTail = mergedListTail.next;
				} else {
					mergedListHead = head1;
					mergedListTail = mergedListHead;
				}
				
				head1 = head1.next;
			}
			else if (head1.value.compareTo(head2.value) > 0) {
				if(mergedListHead != null) {
					mergedListTail.next = head2;
					mergedListTail = mergedListTail.next;
				} else {
					mergedListHead = head2;
					mergedListTail = mergedListHead;
				}
				
				head2 = head2.next;				
			}
			else if (head1.value.compareTo(head2.value) == 0) {
				if(mergedListHead != null) {
					mergedListTail.next = head1;
					head1 = head1.next;
					
					mergedListTail = mergedListTail.next; // this screws up ALL!
					
					mergedListTail.next = head2;
					head2 = head2.next;
					
					mergedListTail = mergedListTail.next;
				} else {
					mergedListHead = head1;
					
					//
					head1 = head1.next;
					mergedListHead.next = head2;
					//
					head2 = head2.next;
					mergedListTail = mergedListHead.next;
				}
				
				//head1 = head1.next;
				//head2 = head2.next;
			}			
			
		}
		
		if(head1 == null && head2 == null) {
			mergedListTail.next = null;
		}
		else if(head1 == null && head2 != null) {
			mergedListTail.next = head2;
		}
		else if(head2 == null && head1 != null) {
			mergedListTail.next = head1;
		}
		
		return mergedListHead;
	}
	
	private Node getMiddle(Node head) {
        if(head == null) { return head; }
        Node slow, fast; slow = fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next; fast = fast.next.next;
        }
        return slow;
    }
	
	
	public static void main(String[] args) {
		
		int count = Integer.parseInt(args[0]);
		System.out.println("[count]: " + count );
		
		SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
		long then = System.currentTimeMillis();
		Random r = new Random(then);
		for(int i=0; i<count; i++) {
			ll.add(r.nextInt(Integer.MAX_VALUE));
		}
		long now = System.currentTimeMillis();
		System.out.println("[generate random]: " + (now-then) + " millis");
		
//		ll.add(99);
//		ll.add(700);
//		ll.add(200);
//		ll.add(650);
//		ll.add(9900);
		
//		System.out.println("in: " + ll);
		then = System.currentTimeMillis();
		ll.sort();
		now = System.currentTimeMillis();
		System.out.println("[sort]: " + (now-then) + " millis");
//		System.out.println("out: " + ll);
		
		
//		System.out.println("middle = " + ll.getMiddle(ll.head).value);
//		
//		System.out.println(ll.toString());
//		System.out.println(ll.contains(700));
//		System.out.println(ll.contains(999));
//		
//		System.out.print(ll.remove(700) + " <> ");
//		System.out.println(ll.toString());
//		
//		System.out.print(ll.remove(100) + " <> ");
//		System.out.println(ll.toString());
//		
//		ll = new SinglyLinkedList<Integer>();
//		ll.add(0);
//		System.out.println(ll);
//		ll.remove(0);
//		System.out.println(ll);
	}
	
	public String str(Node node) {
		StringBuilder buff = new StringBuilder();
		buff.append('[');
		while (node != null) {
			buff.append(node.value).append(",");
			node=node.next;
		}
		
		if( buff.charAt(buff.length()-1) == ',' ) {
			buff.deleteCharAt(buff.length()-1);
		}
		
		buff.append(']');
		
		return buff.toString();
	}
	
}



