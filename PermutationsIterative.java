package com.educative;

import java.util.*;

import java.util.*;

class PermutationsIterative {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutation = new LinkedList<>();
        permutation.add(new ArrayList());
        for(int currentNumber : nums) {
            int n = permutation.size();
            for(int i = 0 ; i < n ; i++) {
                List<Integer> oldPermutation = permutation.poll();
                System.out.println("oldPermutation.size(): "+oldPermutation.size());
                for(int j = 0 ; j <= oldPermutation.size() ; j++) {
                    List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
                    newPermutation.add(j, currentNumber);
                    //System.out.println("newPermutation: "+newPermutation);
                    if(newPermutation.size() == nums.length)
                        result.add(newPermutation);
                    else
                        permutation.add(newPermutation);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = PermutationsIterative.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}

