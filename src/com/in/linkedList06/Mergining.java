package com.in.linkedList06;

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

    public Node mergeSortedLists(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Node result;
        if (a.data <= b.data) {
            result = a;
            result.next = mergeSortedLists(a.next, b);
        } else {
            result = b;
            result.next = mergeSortedLists(a, b.next);
        }
        return result;
    }

    public void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Mergining {
    public static void main(String[] args) {
        LinkedList listA = new LinkedList();
        LinkedList listB = new LinkedList();

        // Adding elements to the first linked list
        listA.insert(5);
        listA.insert(10);
        listA.insert(15);

        // Adding elements to the second linked list
        listB.insert(2);
        listB.insert(3);
        listB.insert(20);

        System.out.print("First list: ");
        listA.display(listA.head);

        System.out.print("Second list: ");
        listB.display(listB.head);

        Node mergedListHead = listA.mergeSortedLists(listA.head, listB.head);

        System.out.print("Merged list: ");
        listA.display(mergedListHead);
    }
}
