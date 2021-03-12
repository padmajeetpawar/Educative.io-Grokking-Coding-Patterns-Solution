package com.educative;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

public class LinkedListCycle {

    private static int hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int cycleLength = 1;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                //return calculateLength(slow);
                ListNode temp = slow;
                slow = slow.next;
                while ( temp != slow ){
                    slow = slow.next;
                    cycleLength++;
                }
                break;
            }


        }
        System.out.println(cycleLength);
        return cycleLength;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        //System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        //head.next.next.next.next.next.next = head.next.next.next;
        //System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
    }


}
