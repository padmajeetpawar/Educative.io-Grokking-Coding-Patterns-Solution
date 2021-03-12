package com.educative;

import java.util.*;

class MaximumDistinctElements {

    public static int findMaximumDistinctElements(int[] nums, int k) {
        int distinctElements = 0;
        HashMap<Integer,Integer> frequencyMap = new HashMap();
        for(int i = 0 ; i < nums.length ; i++)
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);

        //System.out.println(frequencyMap);

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((e1,e2) -> (e1.getValue() - e2.getValue()));

        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()) {
            if(entry.getValue() == 1)
                distinctElements++;
            else
                minHeap.add(entry);
        }

        //System.out.println(minHeap);

        while( k > 0 && !minHeap.isEmpty()) {
            Map.Entry<Integer,Integer> entry = minHeap.poll();
            k -= entry.getValue() - 1;

            if( k >= 0)
                distinctElements++;
        }

        if( k > 0)
            distinctElements -= k;

        return distinctElements;
    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}