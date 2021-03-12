package com.educative;

class LinkedListCycleStart {

    private static ListNode findCycleStart(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int cycleLength = 0;
        while( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if( fast == slow) {
                cycleLength = CalculateCycleLength(slow);
                break;
            }
        }
        //System.out.println(cycleLength);
        return getCycleStart(cycleLength, head);
        //return head;
    }

    private static ListNode getCycleStart(int cycleLength, ListNode head) {
        int i = 0;
        ListNode pointer2 = head;
        ListNode pointer1 = head;
        while( i < cycleLength) {
            pointer2 = pointer2.next;
            i++;
        }

        while ( pointer1 != pointer2 ) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }

    private static int CalculateCycleLength(ListNode slow) {
        int length = 1;
        ListNode current = slow;
        current = current.next;
        while ( current != slow ) {
            current = current.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}
