package com.educative;

import java.util.*;

public class MiddleOfLinkedList {

    private static ListNode findMiddle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

//        List<ListNode> list = new ArrayList<>();
//        ListNode pointer = head;
//
//        while (pointer != null) {
//            list.add(pointer);
//            pointer = pointer.next;
//        }
//        int middleIndex = (int)Math.ceil(list.size()/(double)2);
//        System.out.println("List Size: "+ list.size());
//        System.out.println("Middle Index: "+ middleIndex);
//
//        if (list.size() % 2 == 0)
//            return list.get(middleIndex);
//        else
//            return list.get(middleIndex - 1);

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
    }


}
