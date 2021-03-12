package com.educative;

public class DutchFlag {

    private static void sort(int[] arr) {
        int high = arr.length - 1;
        int low = 0;
        int i = 0;
        while( i <= high ) {
            if(arr[i] == 0) {
                swap(arr,i,low);
                i++;
                low++;
            }else if( arr[i] == 1) {
                i++;
            }else {
                swap(arr, i, high);
                high--;
            }

        }
    }

    private static void swap(int[] arr, int i, int low) {
        int temp = arr[low];
        arr[low] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }


}
