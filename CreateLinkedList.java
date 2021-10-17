package com.bridgelabz.day14linkedlist;
class node<T> {    
    T data;
    node<T> next;
    node(T data){
        this.data = data;
        this.next = null;
    }
}
 
class LinkedList<T> {
    node<T> head;
    private int length = 0;
    LinkedList() { 
    	this.head = null; 
    }
    
 // Method To add node 
    void add(T data) {
        node<T> temp = new node<>(data);
        if (this.head == null) {
            head = temp;
        }
        else {
            node<T> X = head;
            while (X.next != null) {
                X = X.next;
            }
            X.next = temp;
        }
        length++;
    }   
 
    // Method To display the LinkedList
    public String toString(){
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
 
public class CreateLinkedList {
 
    // main driver method
    public static void main(String[] args) {
    	LinkedList<Integer> linkedlist = new LinkedList<>();
        System.out.println("LinkedList created:");        
        linkedlist.add(56);
        linkedlist.add(30);
        linkedlist.add(70);
        System.out.println("list after adding 56,30 and 70 :");
        System.out.println(linkedlist);
    }
}