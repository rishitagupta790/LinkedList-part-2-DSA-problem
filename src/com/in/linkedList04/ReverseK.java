package com.in.linkedList04;


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

    public Node reverseAlternateKNodes(Node head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        // Reverse the first k nodes
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Skip the next k nodes
        count = 0;
        while (current != null && count < k - 1) {
            current = current.next;
            count++;
        }

        // Recursively reverse the remaining alternate k nodes
        if (current != null) {
            current.next = reverseAlternateKNodes(current.next, k);
        }

        // Connect the reversed k nodes to the rest of the list
        prev.next = current;

        return prev;
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

public class ReverseK {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding elements to the linked list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);
        list.insert(10);

        System.out.print("Original list: ");
        list.display(list.head);

        int k = 3; // Reverse every alternate 3 nodes

        list.head = list.reverseAlternateKNodes(list.head, k);

        System.out.print("List after reversing alternate " + k + " nodes: ");
        list.display(list.head);
    }
}
