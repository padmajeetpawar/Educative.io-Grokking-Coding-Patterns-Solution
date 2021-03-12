package com.educative;

import java.util.*;

class MaximizeCapital {
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        int maxCapital = 0;
        int n = profits.length;
        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n, (i1,i2) -> capital[i1] - capital[i2]);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n, (i1,i2) -> profits[i2] - profits[i1]);

        for(int i = 0 ; i < n ; i++) {
            minCapitalHeap.offer(i);
        }
        maxCapital = initialCapital;
        for(int i = 0 ; i < numberOfProjects ; i++) {

            while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek() <= maxCapital)
                maxProfitHeap.add(minCapitalHeap.poll());

            if(maxProfitHeap.isEmpty())
                break;

            maxCapital += profits[maxProfitHeap.poll()];;

        }
        return maxCapital;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}
