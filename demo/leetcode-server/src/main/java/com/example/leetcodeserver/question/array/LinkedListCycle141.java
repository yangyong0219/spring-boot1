package com.example.leetcodeserver.question.array;

import com.example.leetcodeserver.untils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle141 {
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
//        node5.next = node2;
        LinkedListCycle141 linkedListCycle141 = new LinkedListCycle141();
        boolean b = linkedListCycle141.hasCycle1(node1);
        System.out.println(b);
    }

    public boolean hasCycle(ListNode head) {
        //Hash法
//        Set<ListNode> exist = new HashSet<>();
//        while (head != null) {
//            if (!exist.add(head)) {
//                return true;
//            }
//            head = head.next;
//        }
//        return false;

        //快慢指针
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        return true;
    }

    public boolean hasCycle1(ListNode head) {

        return false;
    }

}
