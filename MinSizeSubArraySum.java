package com.educative;

public class MinSizeSubArraySum {

    private static int findMinSubArray(int s, int[] arr) {
        int windowStart = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int windowEnd = 0 ; windowEnd < arr.length ; windowEnd++) {
            sum += arr[windowEnd];
            while(sum >= s) {
                ans = Math.min(ans,windowEnd - windowStart + 1);
                //System.out.println(ans);
                sum -= arr[windowStart];
                windowStart++;
            }
        }



        return ans;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }


}
