package com.educative;

import java.util.*;

class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        int num = 0;
        for (int i=0; i < arr.length; i++) {
            System.out.print(num + " ^ " + arr[i]);
            num = num ^ arr[i];
            System.out.println(" = "+num);
        }
        System.out.println("4 xor 6: "+ (4 ^ 6));
        return num;
    }

    public static void main( String args[] ) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}