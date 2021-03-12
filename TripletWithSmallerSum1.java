package com.educative;

import java.util.*;

public class TripletWithSmallerSum1 {

    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for ( int i = 0 ; i < arr.length - 2 ; i++) {
            count += searchPair(arr,i,target);
        }
        return count;
    }

    private static int searchPair(int[] arr, int index, int target) {
        int count = 0;
        int left = index + 1;
        int right = arr.length - 1;
        while ( left < right ) {
            if( arr[index] + arr[left] + arr[right] < target ) {
                count += right - left;
                left++;
            }else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum1.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum1.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
