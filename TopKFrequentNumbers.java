package com.educative;

import java.util.*;

class TopKFrequentNumbers {

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);


        System.out.println(map);


        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            minHeap.add(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }


        while(!minHeap.isEmpty()) {
            topNumbers.add(minHeap.poll().getKey());
        }

        return topNumbers;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 11, 12, -1, 12, 7, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}

