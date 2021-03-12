package com.educative;

public class MaxSumSubArrayOfSizeK {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 5};
        int k=2;
        int windowStart = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int windowEnd = 0 ; windowEnd < arr.length ; windowEnd++) {
            sum += arr[windowEnd];
            if(windowEnd >= k-1){
                maxSum = Math.max(maxSum,sum);
                sum -= arr[windowStart];
                windowStart++;
            }
        }
    System.out.println(maxSum);
    }

}
