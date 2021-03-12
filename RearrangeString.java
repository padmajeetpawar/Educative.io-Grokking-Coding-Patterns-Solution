package com.educative;

import java.util.*;

class RearrangeString {

    public static String rearrangeString(String str) {
        HashMap<Character,Integer> charFrequencyMap = new HashMap();

        for(char chr : str.toCharArray()) {
            charFrequencyMap.put(chr , charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<Map.Entry<Character,Integer>>((e1,e2) -> (e2.getValue() - e1.getValue()));
        maxHeap.addAll(charFrequencyMap.entrySet());

        //System.out.println(maxHeap);
        StringBuilder resultString = new StringBuilder(str.length());
        Map.Entry<Character,Integer> previousEntry = null;

        while(!maxHeap.isEmpty()) {

            Map.Entry<Character,Integer> currentEntry = maxHeap.poll();

            if(previousEntry != null && previousEntry.getValue() > 0 )
                maxHeap.offer(previousEntry);
            resultString.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            previousEntry = currentEntry;
        }


        return resultString.length() == str.length() ?  resultString.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}
