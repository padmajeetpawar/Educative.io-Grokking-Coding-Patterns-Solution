package com.educative;

class ArrayReader {
    int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;
        return arr[index];
    }
}

class SearchInfiniteSortedArray {

    public static int search(ArrayReader reader, int key) {
        int start = 0;
        int end = 1;

        while(reader.get(end) < key) {
            int newStart = end + 1;
            end = (end - start + 1) * 2;
            start = newStart;
        }

        return binarySearch(reader, key, start, end);

    }

    private static int binarySearch(ArrayReader reader, int key, int start, int end) {

        while(start <= end){
            int mid = start + (end - start)/2;
            if(reader.get(mid) == key)
                return mid;
            else if(reader.get(mid) < key)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 16));
        System.out.println(SearchInfiniteSortedArray.search(reader, 11));
        reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 15));
        System.out.println(SearchInfiniteSortedArray.search(reader, 200));
    }
}