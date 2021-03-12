package com.educative;

import java.util.Arrays;

public class TripletSumCloseToTarget {

    private static int searchTriplet(int[] arr, int target) {
        Arrays.sort(arr);
        int closestSum = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 0 ;i < arr.length -2;i++) {
            closestSum = searchPair(arr, i,arr.length-1,target);
            result = Math.max(result, closestSum);
        }
        return result;
    }

    private static int searchPair(int[] arr, int index, int right,int target) {
        int left = index + 1;
        int result = 0;
        while(left < right) {
            int currentSum = arr[index] + arr[left] + arr[right];
            if(currentSum <= target) {
                result = Math.max(result,currentSum);
                left++;
            }else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }


}
