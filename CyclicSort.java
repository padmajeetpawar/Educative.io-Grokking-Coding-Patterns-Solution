package com.educative;

import java.util.Arrays;

class CyclicSort {

    public static void sort(int[] arr) {
        int i = 0;
        while ( i < arr.length) {
            if(arr[i] != i+1){
                swap(arr,arr[i]-1,i);
            }else {
                i++;
            }
        }
        //System.out.println(Arrays.asList(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        System.out.println(Arrays.toString(arr));
        CyclicSort.sort(arr);

        for (int num : arr)
            System.out.print(num + " ");
        System.out.println("\n");

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        System.out.println(Arrays.toString(arr));
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        System.out.println(Arrays.toString(arr));
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}

