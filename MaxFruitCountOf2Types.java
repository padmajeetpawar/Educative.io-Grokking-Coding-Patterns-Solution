package com.educative;

import java.util.HashSet;
import java.util.Set;

public class MaxFruitCountOf2Types {

    private static int findLength(char[] arr) {
        int windowStart = 0;
        int result = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();

        for(int windowEnd = 0 ; windowEnd < arr.length ; windowEnd++) {
            set.add(arr[windowEnd]);
            //System.out.println(set);
            if(set.size() > 2) {
                set.remove(arr[windowStart]);
                windowStart++;
            }
            result = Math.max(result, windowEnd - windowStart + 1);
            //System.out.println("result: "+result);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
