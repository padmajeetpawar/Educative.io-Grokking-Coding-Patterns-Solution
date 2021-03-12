package com.educative;

class MinimumDifference {

    public static int searchMinDiffElement(int[] arr, int key) {
        int result = 0, difference = Integer.MAX_VALUE;
        if (key < arr[0])
            return arr[0];
        if (key > arr[arr.length - 1])
            return arr[arr.length - 1];

        int start = 0, end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(arr[mid] == key)
                return arr[mid];
//            int currentDifference = Math.abs(arr[mid] - key);
//            if(currentDifference < difference) {
//                //System.out.println("inside if");
//                result = arr[mid];
//                difference = currentDifference;
//                //System.out.println("result: " + result);
//                //System.out.println("difference: " + difference);
//            }
            if(arr[mid] < key) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }

        }
        if ((arr[start] - key) < (key - arr[end]))
            return arr[start];
        return arr[end];
        //return result;
    }

    public static void main(String[] args) {
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10, 11, 112, 119 ,120 }, 67));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(MinimumDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}