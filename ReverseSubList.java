package com.educative;

class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        for(int i = 0 ; i < p - 1; i++) {
            previous = current;
            current = current.next;
        }

        ListNode node1 = previous;
        ListNode node2 = current;

        for(int i = 0 ; i < q-p+1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if(node1 != null)
            node1.next = previous;
        else
            head = previous;

        node2.next = current;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = ReverseSubList.reverse(head, 1, 6);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}