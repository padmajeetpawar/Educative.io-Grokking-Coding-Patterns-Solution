package com.educative;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatSubstring {

    private static int findLength(String str) {
        int maxSubstring = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for(int windowEnd = 0 ; windowEnd < str.length() ; windowEnd++) {
            if(set.contains(str.charAt(windowEnd)))
                set.clear();
            set.add(str.charAt(windowEnd));
            maxSubstring = Math.max(maxSubstring,set.size());
            System.out.println(set);
        }
        return maxSubstring;
    }
    public static void main(String[] args) {
        //System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb")); //abc
        //System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }


}
