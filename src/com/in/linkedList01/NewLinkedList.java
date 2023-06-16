package com.in.linkedList01;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class NewLinkedList {
    Node head;

    public NewLinkedList() {
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

    public static NewLinkedList createNewList(NewLinkedList list1, NewLinkedList list2) {
        if (list1 == null || list2 == null || list1.head == null || list2.head == null) {
            return null;
        }

        NewLinkedList newList = new NewLinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            int data1 = current1.data;
            int data2 = current2.data;
            if (data1 > data2) {
                newList.insert(data1);
            } else {
                newList.insert(data2);
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return newList;
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
        NewLinkedList list1 = new NewLinkedList();
        NewLinkedList list2 = new NewLinkedList();

        // Adding elements to list1
        list1.insert(2);
        list1.insert(8);
        list1.insert(3);

        // Adding elements to list2
        list2.insert(9);
        list2.insert(4);
        list2.insert(7);

        NewLinkedList newList = NewLinkedList.createNewList(list1, list2);

        System.out.print("New linked list: ");
        newList.display();
    }
    }
