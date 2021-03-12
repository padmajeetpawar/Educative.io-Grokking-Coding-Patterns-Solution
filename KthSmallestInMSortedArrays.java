package com.educative;

import java.util.*;

class Node {
    int listIndex;
    int elementIndex;

    Node(int elementIndex, int listIndex) {
        this.elementIndex = elementIndex;
        this.listIndex = listIndex;
    }
}

class KthSmallestInMSortedArrays {

    public static int findKthSmallest(List<Integer[]> lists, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1,n2) -> (lists.get(n1.listIndex)[n1.elementIndex] - lists.get(n2.listIndex)[n2.elementIndex]));

        for(int i = 0 ; i < lists.size() ; i++) {
            if(lists.get(i) != null)
                minHeap.add(new Node(0,i));
        }

        int smallestElementCount = 0, result = 0;

        while(!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result = lists.get(node.listIndex)[node.elementIndex];

            if(++smallestElementCount == k)
                break;

            node.elementIndex++;
            if(lists.get(node.listIndex).length > node.elementIndex) {
                minHeap.add(node);
            }
        }

        //System.out.println(minHeap);
        return result;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
