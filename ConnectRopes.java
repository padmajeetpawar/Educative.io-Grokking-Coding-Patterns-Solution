package com.educative;

import java.util.*;

class ConnectRopes {

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        int result = 0;
        if(ropeLengths.length == 1)
            return ropeLengths[0];

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2) -> (n1 - n2));

        for(int i = 0 ; i < ropeLengths.length ; i++) {
            minHeap.add(ropeLengths[i]);
        }

        for(int i = 0 ; i < ropeLengths.length - 1 ; i++) {
            int cost = minHeap.poll() + minHeap.poll();
            result += cost;
            minHeap.add(cost);
        }

        return result;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}

