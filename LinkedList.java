/*
 * Problem : Linked List using generics - 
 * Operations : Create, Add,Insert, Delete
 */
package com.bridgelabz.day14;
import java.io.*;

class node<T> {
	T data;
	node<T> next;

	node(T data)
	{
		this.data = data;
		this.next = null;
	}
}

class CreateLinkedlist<T> {
	node<T> head;
	private int length = 0;

	CreateLinkedlist(){ 
		this.head = null; 
	}
	// Method To add node at the end of List
	void add(T data)
	{
		node<T> temp = new node<>(data);
		// Checking if list is empty and assigning new value to head node
		if (this.head == null) {
			head = temp;
		}

		else {
			// Temporary node for traversal
			node<T> X = head;
			while (X.next != null) {
				X = X.next;
			}
			X.next = temp;
		}
		length++;
	}

	// Method To add new node at any given position
	void add(int position, T data)
	{
		if (position > length + 1) {
			System.out.println("Position Unavailable in LikedList");
			return;
		}

		// If new position is head then replace head node
		if (position == 1) {
			node<T> temp = head;
			head = new node<T>(data);
			head.next = temp;
			return;
		}
		// Temporary node for traversal
		node<T> temp = head;
		node<T> prev = new node<T>(null);
		// iterating to the given position
		while (position - 1 > 0) {
			prev = temp;
			temp = temp.next;
			position--;
		}
		prev.next = new node<T>(data);
		prev.next.next = temp;
	}
	// Method To delete a node from list
	void delete(T key)
	{
		node<T> prev = new node<>(null);
		prev.next = head;
		node<T> next = head.next;
		node<T> temp = head;
		boolean exists = false;

		// If head node needs to be deleted
		if (head.data == key) {
			head = head.next;
			exists = true;
		}

		// Iterating over LinkedList
		while (temp.next != null) {
			if (String.valueOf(temp.data).equals(String.valueOf(key))) {
				prev.next = next;
				exists = true;
				break;
			}

			// Previous node now points to current node
			prev = temp;
			// Current node now points to next node
			temp = temp.next;
			// Next node points the node ahead of current
			// node
			next = temp.next;
		}

		// Comparing the last node with the given key value
		if (exists == false && String.valueOf(temp.data).equals(String.valueOf(key))) {
			prev.next = null;
			exists = true;
		}

		// If node to be deleted exists
		if (exists) {
			length--;
		}
		else {
			System.out.println("Given Value is not present in linked list");
		}
	}

	// Method To clear the entire LinkedList
	void clear()
	{
		head = null;
		length = 0;
	}

	// Method Returns whether List is empty or not
	boolean empty()
	{
		if (head == null) {
			return true;
		}
		return false;
	}
	
	// Method Returning the length of LinkedList
	int length() { return this.length; }

	// Method To display the LinkedList
	public String toString()
	{
		String S = "{ ";

		node<T> X = head;

		if (X == null)
			return S + " }";

		while (X.next != null) {
			S += String.valueOf(X.data) + " -> ";
			X = X.next;
		}

		S += String.valueOf(X.data);
		return S + " }";
	}
}

public class LinkedList {

	// main driver method
	public static void main(String[] args)
	{
		CreateLinkedlist<Integer> list1 = new CreateLinkedlist<>();
		System.out.println("Integer LinkedList created as list1 :");
		
		list1.add(56);
		list1.add(30);
		list1.add(70);
		System.out.println("list1 after adding 56,30 and 70 :");
		System.out.println(list1);
		list1.add(40,2);
		list1.delete(30);
		System.out.println("list1 after removing 30 :");
		list1.clear();
		
		CreateLinkedlist<Integer> list2 = new CreateLinkedlist<>();
		System.out.println("Integer LinkedList created as list2 :");
		list2.add(70,1);
		list2.add(30,2);
		list2.add(56,3);
		System.out.println("list2 after adding 56,30 and 70 :");
		System.out.println(list2);
		list2.delete(70);
		System.out.println("list2 after removing 70 :");

	}
}
