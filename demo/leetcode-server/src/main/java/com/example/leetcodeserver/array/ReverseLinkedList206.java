package com.example.leetcodeserver.array;

import com.example.leetcodeserver.untils.ListNode;

public class ReverseLinkedList206 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ReverseLinkedList206 reverseLinkedList206 = new ReverseLinkedList206();
        ListNode node = reverseLinkedList206.reverseList(node1);
        System.out.println(node);

    }
    public ListNode reverseList(ListNode head) {
        //双指针，一个指针指向当前节点，并讲当前节点指向新的下一个节点（pre） 由于指向新的下一个节点后，当前节点的原下一个节点获取不到了
        //所以要先获取当前指针的原下一个节点，之后再将当前指针指向新的下一个节点，再讲原下一个节点当作新的现在的节点 继续重复
//        ListNode pre = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = pre;
//            pre = curr;
//            curr = next;
//        }
//        return pre;

        //递归
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = reverseList(head.next);
        //这里head是倒数第二个，然后倒数第二个的下一个的下一个是自己，就完成了反转
        head.next.next = head;
        //去掉环
        head.next = null;
        return curr;
    }

    public ListNode reverseList1(ListNode head) {
//        ListNode pre = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = pre;
//            pre = curr;
//            curr = next;
//
//        }
//        return pre;

        //递归
        if (head == null || head.next == null) return head;
        ListNode curr = reverseList(head);
        curr.next.next = curr;
        curr.next = null;
        return curr;

    }

}
