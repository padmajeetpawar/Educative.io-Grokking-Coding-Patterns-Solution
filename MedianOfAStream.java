package com.educative;

import java.util.*;

class MedianOfAStream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianOfAStream() {
        maxHeap =  new PriorityQueue<>((a,b) -> b - a);
        minHeap =  new PriorityQueue<>((a,b) -> a - b);
    }

    public void insertNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }

        //Balance the number of elements in each Heap
        //If no of elements are odd then extra element we will keep in maxHeap so that we can return the same as median
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }else if(maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek())/(double)2;
        else
            return maxHeap.peek();
        //return -1;
    }

    
    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}

