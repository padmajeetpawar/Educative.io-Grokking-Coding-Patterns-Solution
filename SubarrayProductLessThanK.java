package com.educative;

import java.util.*;


public class SubarrayProductLessThanK {

    private static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int windowStart = 0;
        int currentProduct = 1;
        for (int windowEnd = 0 ; windowEnd < arr.length ; windowEnd++) {
            if(windowEnd > 0 && arr[windowEnd] < target && !list.contains(Arrays.asList(arr[windowEnd]))) {
                list.add(Arrays.asList(arr[windowEnd]));
            }
            currentProduct *= arr[windowEnd];
            while( currentProduct >= target && windowStart < arr.length) {
                currentProduct /= arr[windowStart];
                windowStart++;
            }
            if(currentProduct < target) {
                List<Integer> l = new ArrayList<>();
                int k = windowStart;
                while (k <= windowEnd) {
                    l.add(arr[k]);
                    k++;
                }
                if(!list.contains(l))
                    list.add(l);
            }
        }

        return list;
    }
    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        //System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }


}
