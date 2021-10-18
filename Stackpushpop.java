package com.bridgelabz.day14;


public class Stackpushpop {
	class Node {
		int data;
		Node next;
	}
	private Node top;
	
	public Stackpushpop() {
		this.top = null;
	}

	// Utility function to add an element `x` to the stack
	public void push(int x) {
		Node node = new Node();

		System.out.println("Pushing " + x);

		node.data = x;

		node.next = top;

		// update top pointer
		top = node;
	}

	// Method to check if the stack is empty or not
	public boolean isEmpty() {
		return top == null;
	}

	// Method to return the top element of the stack
	public int peak() {

		if (!isEmpty()) {
			return top.data;
		} else {
			System.out.println("The stack is empty");
			return -1;
		}
	}

	// method to pop a top element from the stack
	public void pop() {
		// check for stack underflow
		if (top == null) {
			System.out.print("\nStack Underflow");
			return;
		}

		System.out.println("Pop " + peak());

		// update the top pointer to point to the next node
		top = (top).next;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Stack and Queues");
		Stackpushpop s = new Stackpushpop();

		s.push(70);
		s.push(30);
		s.push(56);
		System.out.println("The top element is " + s.peak());

		s.pop();
		s.pop();
		s.pop();
		if (s.isEmpty()) {
			System.out.print("The stack is empty");
		} 
		else {
			System.out.print("The stack is not empty");
		}

	}
}