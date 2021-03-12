package com.educative;

import java.util.*;

class Entry {
    int key;
    int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class KClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        List<Integer> result = new ArrayList<>();
        /*PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2) -> (n1 - n2));
        for(int i = 0 ; i < K ; i++)
            minHeap.add(arr[i]);

        for(int i = K ; i < arr.length ; i++) {
            if(Math.abs(minHeap.peek() - X) > Math.abs(arr[i] - X)) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        while(!minHeap.isEmpty())
            result.add(minHeap.poll());*/

        //Binary Search and priority queue

        int index = binarySearch(arr, X);
        /*int low = Math.max(index - K , 0);
        int high = Math.min(index + K , arr.length - 1);


        PriorityQueue<Entry> minHeap = new PriorityQueue<>((n1,n2) -> (n1.key - n2.key));

        for(int i = low ; i <= high ; i++) {
            minHeap.add(new Entry(Math.abs(arr[i] - X), arr[i]));
        }

        for(int i = 0 ; i < K ; i++) {
            result.add(minHeap.poll().value);
        }

        Collections.sort(result);*/
        List<Integer> result1 = new LinkedList<>();
        int leftPointer = index;
        int rightPointer = index + 1;

        for(int i = 0 ; i < K ;i++) {
            if(leftPointer >=0 && rightPointer < arr.length) {
                int diff1 = Math.abs(X - arr[leftPointer]);
                int diff2 = Math.abs(X - arr[rightPointer]);
                if (diff1 <= diff2) {
                    result1.add(0, arr[leftPointer--]);
                } else {
                    result1.add(arr[rightPointer++]);
                }
            }
            else if(leftPointer >= 0) {
                result1.add(0, arr[leftPointer--]);
            }
            else if (rightPointer < arr.length) {
                result1.add(arr[rightPointer++]);
            }
            
        }
        return result1;
    }

    private static int binarySearch(int[] arr, Integer x) {
        int low = 0;
        int high = arr.length - 1;
        while( low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] == x)
                return mid;
            else if(arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }

        if(low > 0)
            return low - 1;
        return low;
    }

    public static void main(String[] args) {
        List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}
