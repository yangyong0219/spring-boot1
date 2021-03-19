package com.example.demo.linked;

public class Node {
    int data;
    Node next;

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {


        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node() {
    }

    public Node(Node next) {
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
    }


}
