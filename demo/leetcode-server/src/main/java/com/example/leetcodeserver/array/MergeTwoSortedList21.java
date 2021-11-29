package com.example.leetcodeserver.array;

import com.example.leetcodeserver.untils.ListNode;

public class MergeTwoSortedList21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l3;
        l3.next = l5;
        l5.next = l7;

        l2.next = l4;
        l4.next = l6;
        MergeTwoSortedList21 mergeTwoSortedList21 = new MergeTwoSortedList21();
        ListNode node = mergeTwoSortedList21.mergeTwoLists(l1, l2);
        System.out.println(node);


    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //1. 递归 终止条件是l1 == null 或l2 == null
//        if (l1 == null) {
//            return l2;
//        } else if (l2 == null) {
//            return l1;
//        } else if (l1.val > l2.val) {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        } else {
//            l1.next = mergeTwoLists(l2, l1.next);
//            return l1;
//        }

        //2. 迭代
        ListNode pre = new ListNode(-1);
        ListNode move = pre;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                move.next = l2;
                l2 = l2.next;
            } else {
                move.next = l1;
                l1 = l1.next;
            }
            move = move.next;
        }
        move.next = l1 == null ? l2 : l1;
        return pre.next;
    }

}
