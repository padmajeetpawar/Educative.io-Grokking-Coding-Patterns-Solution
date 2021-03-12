package com.educative;

import java.util.Arrays;

class MissingNumber {

    public static int findMissingNumber(int[] arr) {
        int i = 0;
//        for(int i = 0 ; i < arr.length ; i++) {
//            sum += arr[i];
//        }
//        int totalSum = (int)((arr.length + 1)/(float)2 * (arr.length));
        while( i < arr.length ) {
            if( arr[i] < arr.length && arr[i] != arr[arr[i]]) {
                swap(arr,i, arr[i]);
            }else {
                i++;
            }
        }
        for (i = 0; i < arr.length; i++)
            if (arr[i] != i)
                return i;

        return arr.length;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(MissingNumber.findMissingNumber(new int[] { 7, 3, 5, 2, 4, 6, 0, 1 }));
    }
}

