package com.educative;

class ReverseEveryKElements {

    public static ListNode reverseByKElements(ListNode head, int k) {
        ListNode current = head;
        ListNode previous = null;

        while (true) {
            ListNode lastNodeOfPreviousPart = previous;
            ListNode lastNodeOfSubList = current;
            ListNode next = null;

            for(int i = 0 ; current != null && i < k; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            if(lastNodeOfPreviousPart != null)
                lastNodeOfPreviousPart.next = previous;
            else
                head = previous;

            lastNodeOfSubList.next = current;



            previous = lastNodeOfSubList;
            for( int i = 0 ; current != null &&  i < k ;i++){
                previous = current;
                current = current.next;
            }
            if (current == null)
                break;


        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverseByKElements(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
