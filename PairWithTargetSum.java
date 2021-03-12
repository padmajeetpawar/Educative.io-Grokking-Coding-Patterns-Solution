package com.educative;

import java.util.*;

public class PairWithTargetSum {

    private static int[] search(int[] arr, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for( int i = 0 ; i < arr.length ; i++ ) {
            if(map.containsKey(target - arr[i]))
                return new int[] { map.get(target - arr[i]), i};
            else
                map.put(arr[i], i);
        }
//        int left = 0;
//        int right = arr.length-1;
//        while (left < right) {
//            if((arr[left] + arr[right]) == target) {
//                return new int[] {left,right};
//            }else if ((arr[left] + arr[right]) > target) {
//                right--;
//            }else {
//                left++;
//            }
//        }

        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }


}
