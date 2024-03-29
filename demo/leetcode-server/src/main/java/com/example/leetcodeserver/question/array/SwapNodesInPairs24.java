package com.example.leetcodeserver.question.array;

import com.example.leetcodeserver.untils.ListNode;

public class SwapNodesInPairs24 {
    public static void main(String[] args) {
        SwapNodesInPairs24 swapNodesInPairs24 = new SwapNodesInPairs24();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = swapNodesInPairs24.swapPairs1(node1);
        System.out.println(node);
    }

    public ListNode swapPairs(ListNode head) {

        //假如有四个节点
        //0 1 2 3 4 5  0-2  1-3 2-1 即可 就变成了 0 2 1 3 4 5 等于交换了0之后的两个节点
        //所以新建一个节点当作0，每次交换0后面的两个 再让0前进一步
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode curr = pre;
        while (curr.next != null && curr.next.next != null) {
            ListNode one = curr.next;
            ListNode two = curr.next.next;
            curr.next = two;
            one.next = two.next;
            two.next = one;
            curr = one;
        }
        return pre.next;

    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode curr = pre;
        while (curr.next != null && curr.next.next != null) {
            ListNode one = curr.next;
            ListNode two = curr.next.next;
            curr.next = two;
            one.next = two.next;
            two.next = one;
            curr = one;
        }
        return pre.next;


    }
}