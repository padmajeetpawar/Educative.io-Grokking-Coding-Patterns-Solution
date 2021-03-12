package com.educative;

import java.util.*;

public class TripletSumToZero {



    private static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0 ; i < arr.length - 2 ; i++) {
            if(i > 0 && arr[i-1] == arr[i])
                continue;
            searchPair(arr,i+1,-arr[i],triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int left, int target, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while ( left < right) {
            List<Integer> list = new ArrayList<>();
            int currentSum = arr[left] + arr[right];
            if(currentSum == target) {
                list.addAll(Arrays.asList(-target, arr[left], arr[right]));
                if(!triplets.contains(list))
                    triplets.add(list);
                left++;
                right--;
            }else if (currentSum < target) {
                left++;
            }else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}
