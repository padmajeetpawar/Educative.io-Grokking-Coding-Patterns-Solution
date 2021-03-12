package com.educative;

public class SortedArraySquares {

    private static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;
        while(left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if(leftSquare > rightSquare) {
                result[index--] = leftSquare;
                left++;
            }else {
                result[index--] = rightSquare;
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }


}
