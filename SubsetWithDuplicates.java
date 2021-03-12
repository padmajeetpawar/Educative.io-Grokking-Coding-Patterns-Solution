package com.educative;

import java.util.*;

class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        //Start by adding empty subset
        subsets.add(new ArrayList<>());

        for(int currentNumber : nums){
            int n = subsets.size();
            //We will take all existing subset and insert current number in them to create new subsets
            for(int i = 0;i < n ;i++) {
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                if(!subsets.contains(set))
                    subsets.add(set);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}

