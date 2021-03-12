package com.educative;

import java.util.*;

public class PalindromicLinkedList {

    private static boolean isPalindrome(ListNode head) {

        ListNode tempHead = head;
        System.out.println("Old list : ");
        while(tempHead != null) {
            System.out.println(tempHead.value);
            tempHead = tempHead.next;
        }
        if(head == null || head.next == null)
            return true;
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        ListNode tempPrev = prev;
        System.out.println("revesed list : ");
        while(tempPrev != null) {
            System.out.println(tempPrev.value);
            tempPrev = tempPrev.next;
        }
        // while(prev != null) {
        //     System.out.println(prev.val);
        //     prev = prev.next;
        // }

        while(prev != head) {
            if(prev.value != head.value)
                return false;
            else {
                prev = prev.next;
                head = head.next;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(5);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }


}
