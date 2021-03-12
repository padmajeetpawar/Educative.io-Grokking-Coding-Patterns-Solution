package com.educative;

import java.util.*;

public class QuadrupleSumToTarget {

    private static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quad = new ArrayList<>();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for( int i = 0 ; i < arr.length - 3 ; i++) {
            for( int j = i + 1 ; j < arr.length - 2 ; j++ ) {
                helper(arr, i, j , target, quad);
            }
        }
        return quad;
    }

    private static void helper(int[] arr, int i, int j, int target, List<List<Integer>> quad) {
        int left = j + 1;
        int right = arr.length - 1;
        while(left < right) {
            int currentSum = arr[i] + arr[j] + arr[left] + arr[right];
            if(currentSum == target && !quad.contains(Arrays.asList(arr[i], arr[j], arr[left], arr[right]))) {
                quad.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                left++;
                right--;
            }else if(currentSum < target) {
                left++;
            }else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        //System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        //System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { -3, -2, -1, 0, 0, 1, 2, 3}, 0));
        System.out.println("[[-3, -2, 2, 3], [-3, -1, 1, 3], [-3, 0, 0, 3], [-3, 0, 1, 2], [-2, -1, 0, 3], [-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]\n");


    }


}
