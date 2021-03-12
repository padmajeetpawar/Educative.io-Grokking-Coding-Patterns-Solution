package com.educative;

import java.util.*;

class FrequencySort {

    public static String sortCharacterByFrequency(String str) {
        HashMap<Character,Integer> frequencyMap = new HashMap();

        for(int i = 0 ; i < str.length() ; i++)
            frequencyMap.put(str.charAt(i), frequencyMap.getOrDefault(str.charAt(i), 0) + 1);

        //System.out.println(frequencyMap);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>((e1, e2) -> (e2.getValue() - e1.getValue()));

        maxHeap.addAll(frequencyMap.entrySet());

        //System.out.println(maxHeap);

        StringBuilder sortedString = new StringBuilder(str.length());

        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for(int i = 0 ; i < entry.getValue() ; i++) {
                sortedString.append(entry.getKey());
            }
        }
        return String.valueOf(sortedString);
    }

    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
