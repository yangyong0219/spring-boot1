package com.example.demo.linked;

public class TestLinkedNode {
    public static void main(String[] args) {
        TestLinkedNode testLinkedNode = new TestLinkedNode();
        Node testNode1 = new Node(1);
        Node testNode2 = new Node(2);
        Node testNode3 = new Node(3);
        Node testNode4 = new Node(4);
        testNode1.next = testNode2;
        testNode2.next = testNode3;
        testNode3.next = testNode4;
//        Node node = testLinkedNode.preInsert(0, testNode1);
//        Node node = testLinkedNode.midInsert(9, testNode1, 2);
//        Node node = testLinkedNode.lastInsert(9, testNode1);
//        Node node = testLinkedNode.preDelete(testNode1);
        Node node = testLinkedNode.midDelete(testNode1, 2);
        System.out.println(node);

    }

    public Node preInsert(int data, Node head) {
        Node insertNode = new Node(data);
        insertNode.next = head;
        head = insertNode;
        return head;
    }

    public Node midInsert(int data, Node head, int index) {
        Node insertNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = head.next;
        }
        insertNode.next = temp.next;
        temp.next = insertNode;
        return head;
    }

    public Node lastInsert(int data, Node head) {
        Node temp = head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = new Node(data);
        return temp;
    }

    public Node preDelete(Node head) {
        head = head.next;
        return head;
    }

    public Node midDelete(Node head, int index) {
        Node temp = head;
        for (int i = 0; i < index -1 ; i++) {
            head = head.next;
        }
        head.next = head.next.next;
        return temp;
    }
}
