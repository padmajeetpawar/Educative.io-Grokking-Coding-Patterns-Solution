package com.educative;

public class RemoveDuplicates {

    private static int remove(int[] arr) {
        int count = 0;
        for(int i = 0 ; i < arr.length -1; i++) {
            if(arr[i+1] != arr[i]) {
                arr[count++] = arr[i];
            }
        }
        return ++count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
    }


}
