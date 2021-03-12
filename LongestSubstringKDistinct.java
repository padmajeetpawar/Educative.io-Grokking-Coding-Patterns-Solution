package com.educative;

import java.util.*;


public class LongestSubstringKDistinct {

    private static int findLength(String str, int i) {
        int windowStart = 0 ;
        Set<Character> set = new HashSet<>();
        int result = Integer.MIN_VALUE;
        for(int windowEnd = 0 ; windowEnd < str.length() ; windowEnd++) {
            set.add(str.charAt(windowEnd));
            System.out.println(set);
            while(set.size() > i) {
                result = Math.max(result, windowEnd - windowStart);
                System.out.println("result: "+result);
                set.remove(str.charAt(windowStart));
                windowStart++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araacaaai", 2));
        //System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        //System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }


}
