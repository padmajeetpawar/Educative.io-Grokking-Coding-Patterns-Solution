package com.educative;

import java.util.*;

class SlidingWindowMedian {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public SlidingWindowMedian() {
        maxHeap =  new PriorityQueue<>((a,b) -> b - a);
        minHeap =  new PriorityQueue<>((a,b) -> a - b);
    }
    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int j = 0;
        for(int windowEnd = 0 ; windowEnd < nums.length ; windowEnd++) {
            int n = nums[windowEnd];
            if(maxHeap.isEmpty() || maxHeap.peek() >= n) {
                maxHeap.add(n);
            }else{
                minHeap.add(n);
            }
            rebalanceHeaps();

            if(maxHeap.size() + minHeap.size() == k) {
                if(maxHeap.size() == minHeap.size())
                    result[j] = (maxHeap.peek() + minHeap.peek())/(double)2;
                else
                    result[j] = maxHeap.peek();

                if(nums[j] <= maxHeap.peek()) {
                    maxHeap.remove(nums[j]);
                }else {
                    minHeap.remove(nums[j]);
                }
                j++;
            }
            //System.out.println("result: " + Arrays.toString(result));
            //System.out.println("j: " + j);

           rebalanceHeaps();
        }

        return result;
    }

    private void rebalanceHeaps() {
        // either both the heaps will have equal number of elements or max-heap will have
        // one more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}