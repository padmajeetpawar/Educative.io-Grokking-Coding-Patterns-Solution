package com.educative;

import java.util.*;

public class HappyNumber {

    private static boolean isHappy(int num) {
        Set<Integer> seen = new HashSet<>();
         while (num != 1 && !seen.contains(num)) {
             seen.add(num);
             //System.out.println(seen);
             num = getSum(num);
         }

        return num == 1;
    }

    private static int getSum(int n) {
        int sum = 0;
        while ( n > 0) {
            sum += (n%10) * (n%10);
            n = n/10;
        }
        //System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.isHappy(23));
        System.out.println(HappyNumber.isHappy(12));
        System.out.println(HappyNumber.isHappy(3));
    }


}
