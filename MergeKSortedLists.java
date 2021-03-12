package com.educative;

import java.util.*;

class MergeKSortedLists {

    public static ListNode merge(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1,n2) -> (n1.value - n2.value));
        for(ListNode root : lists) {
            minHeap.add(root);
        }
        System.out.println("minHeap: " + minHeap);
        ListNode resultHead = null, resultTail = null;

        while(!minHeap.isEmpty()) {
            ListNode currentNode = minHeap.poll();
            if(resultHead == null){
                resultHead = resultTail = currentNode;
            } else {
                resultTail.next = currentNode;
                resultTail = resultTail.next;
            }
            if(currentNode.next != null) {
                minHeap.add(currentNode.next);
            }
        }
        return resultHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
