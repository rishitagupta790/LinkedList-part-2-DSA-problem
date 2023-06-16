package com.in.linkedList05;


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void deleteLastOccurrence(int key) {
        if (head == null) {
            return;
        }

        Node prev = null;
        Node lastOccurrence = null;
        Node current = head;
        Node nextNode = null;

        while (current != null) {
            if (current.data == key) {
                lastOccurrence = prev;
            }
            prev = current;
            current = current.next;
        }

        if (lastOccurrence == null) {
            return;
        }

        if (lastOccurrence == head) {
            head = head.next;
        } else {
            lastOccurrence.next = lastOccurrence.next.next;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Duplicate {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding elements to the linked list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(2);
        list.insert(5);
        list.insert(2);
        list.insert(6);

        System.out.print("Original list: ");
        list.display();

        int key = 2;
        list.deleteLastOccurrence(key);

        System.out.print("List after deleting last occurrence of " + key + ": ");
        list.display();
    }
}
