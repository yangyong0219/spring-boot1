package com.example.leetcodeserver.array;

import com.example.leetcodeserver.untils.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListCycle142 {
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
        node5.next = node2;
        LinkedListCycle142 linkedListCycle142 = new LinkedListCycle142();
        ListNode node = linkedListCycle142.detectCycle(node1);
        System.out.println(node);
    }

    public ListNode detectCycle(ListNode head) {
        //1. hash法
//         Set<ListNode> exist = new HashSet<>();
//         if(head == null || head.next == null) return null;
//         while(head!=null){
//             if(exist.contains(head)){
//                 return head;
//             } else {
//                 exist.add(head);
//             }
//             head = head.next;
//         }
//         return null;

        //迭代
        //假设，从开始位置到环的位置（不包括环）长度为a ，环的长度为 b
        //第一次相遇时快指针走过的 路程为：fast = 2slow，快指针比满指针多走n圈，所以fast = slow + nb
        //上面两个式子化简得到：slow = nb

        //慢指针每一次到环的起点所走的路程为a + nb
        //现在相遇时慢指针已经走了nb，所以再走a就可以到环相遇的位置，所以此时让快指针指向head
        //当快慢指针相遇即走了a，此时slow或者fast的点就是环的起点
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
