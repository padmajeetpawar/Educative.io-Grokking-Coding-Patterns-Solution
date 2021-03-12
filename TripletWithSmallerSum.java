package com.educative;

import java.util.ArrayList;
import java.util.*;

public class TripletWithSmallerSum {


    private static int searchTriplets(int[] arr, int k) {
        Set<List<Integer>> list = new HashSet<>();
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length - 2 ; i++) {
            for( int j = i + 1 ; j < arr.length - 1 ; j++ )
                searchPairs(arr, i, j,arr.length-1, k, list);
        }
        System.out.println(Arrays.asList(list));
        return list.size();
    }

    private static Set<List<Integer>>  searchPairs(int[] arr, int index, int left, int right, int target, Set<List<Integer>> list) {
        while (left < right) {
            int currentSum = arr[index] + arr[left] + arr[right];
            if(currentSum < target) {
                //System.out.println(arr[index] + " " + arr[left] + " " + arr[right]);
                list.add(Arrays.asList(arr[index], arr[left], arr[right]));
            }
            right--;
        }
        return list;
    }

    public static void main(String[] args) {
        //System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }


}
