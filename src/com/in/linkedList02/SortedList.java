package com.in.linkedList02;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SortedList {
    Node head;

    public SortedList() {
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

    public void removeDuplicates() {
        if (head == null) {
            return;
        }

        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
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



    public static void main(String[] args) {
        SortedList list = new SortedList();

        // Adding elements to the sorted list
        list.insert(11);
        list.insert(11);
        list.insert(11);
        list.insert(21);
        list.insert(43);
        list.insert(43);
        list.insert(60);

        System.out.print("Original list: ");
        list.display();

        list.removeDuplicates();

        System.out.print("List after removing duplicates: ");
        list.display();
    }
}
