package com.educative;

import java.util.*;

class GeneralizedAbbreviation {

    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<String>();
        Queue<String> queue = new LinkedList<>();
        int index = 0;
        queue.add("");

        while (!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0 ; i < n ; i++) {
                String str = queue.poll();
                if(index >= word.length())
                    result.add(str);
                else{
                    queue.add(str + word.charAt(index));
                    if(str.length() > 0 && Character.isDigit(str.charAt(str.length() - 1))) {
                        int num = Character.getNumericValue(str.charAt(str.length() - 1)) + 1;
                        queue.add(str.substring(0,str.length() - 1) + num);
                    }else{
                        queue.add(str + 1);
                    }
                }
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}

