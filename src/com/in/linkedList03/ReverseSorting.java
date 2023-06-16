package com.in.linkedList03;


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

    public Node reverseKNodes(Node head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node current = head;

        int count = 0;
        while (current != null) {
            count++;
            if (count % k == 0) {
                prev = reverseGroup(prev, current.next);
                current = prev.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }

    private Node reverseGroup(Node prev, Node next) {
        Node last = prev.next;
        Node current = last.next;

        while (current != next) {
            last.next = current.next;
            current.next = prev.next;
            prev.next = current;
            current = last.next;
        }

        return last;
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

public class ReverseSorting {
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

        System.out.print("Original list: ");
        list.display(list.head);

        int k = 3; // Reverse every 3 nodes

        list.head = list.reverseKNodes(list.head, k);

        System.out.print("List after reversing every " + k + " nodes: ");
        list.display(list.head);
    }
}
