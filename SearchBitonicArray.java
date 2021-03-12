package com.educative;

class SearchBitonicArray {

    public static int search(int[] arr, int key) {
        int start = 0;int end = arr.length -1;
        int maxIndex = findMaxIndex(arr, start, end);
        int searchIndex = binarySearch(arr, start, maxIndex, key);
        if(searchIndex != -1)
            return searchIndex;
        return binarySearch(arr, maxIndex + 1, end, key);
    }

    private static int binarySearch(int[] arr, int start, int end, int key) {
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(key == arr[mid])
                return mid;
            if(arr[start] < arr[end])
                if(key > arr[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            else
                if(key > arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
        }
        return -1;
    }

    private static int findMaxIndex(int[] arr, int start, int end) {
        while(start < end) {
            int mid = start + (end - start)/2;

            if(arr[mid] < arr[mid + 1]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
}