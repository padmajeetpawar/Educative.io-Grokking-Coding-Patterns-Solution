package com.educative;

import java.util.*;

class SumOfElements {

    public static int findSumOfElements(int[] nums, int k1, int k2) {
        int sumOfElements = 0;
        /*Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));


        for(int i = k1 ; i < k2 - 1 ; i++)
            sumOfElements += nums[i];

         */

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1,n2) -> (n2 - n1));

        for(int i = 0 ; i < nums.length ; i++) {
            if(i < k2 -1)
                maxHeap.add(nums[i]);
            else if(nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }
        //N* logK2

        for(int i = 0 ; i < k2 - k1 - 1 ; i++)
            sumOfElements += maxHeap.poll();



        return sumOfElements;
    }

    public static void main(String[] args) {
        int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}
