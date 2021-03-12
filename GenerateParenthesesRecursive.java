package com.educative;

import java.util.*;

public class GenerateParenthesesRecursive {

    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<String>();
        return result;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParenthesesRecursive.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParenthesesRecursive.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
