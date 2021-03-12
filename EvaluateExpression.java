package com.educative;

import java.util.*;

class EvaluateExpression {
    public static List<Integer> diffWaysToEvaluateExpression(String input) {
        List<Integer> result = new ArrayList<>();
        // base case: if the input string is a number, parse and add it to output.
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.parseInt(input));
            System.out.println("result: "+result+"\n");
        } else {
            for (int i = 0; i < input.length(); i++) {
                char chr = input.charAt(i);
                if (!Character.isDigit(chr)) {
                    // break the equation here into two parts and make recursively calls
                    System.out.println("leftpartstring: "+input.substring(0, i));
                    System.out.println("rightpartstring: "+input.substring(i + 1));
                    List<Integer> leftParts = diffWaysToEvaluateExpression(input.substring(0, i));
                    List<Integer> rightParts = diffWaysToEvaluateExpression(input.substring(i + 1));
                    System.out.println("leftParts: "+leftParts);
                    System.out.println("rightParts: "+rightParts);
                    for (int part1 : leftParts) {
                        for (int part2 : rightParts) {
                            if (chr == '+')
                                result.add(part1 + part2);
                            else if (chr == '-')
                                result.add(part1 - part2);
                            else if (chr == '*')
                                result.add(part1 * part2);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
        System.out.println("Expression evaluations: " + result);

//        result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
//        System.out.println("Expression evaluations: " + result);
    }
}
