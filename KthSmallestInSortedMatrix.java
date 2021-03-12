package com.educative;

import java.util.*;

class MatrixNode {
    int row;
    int col;

    MatrixNode(int row, int col) {
        this.row = row;
        this.col = col;
    }

}

class KthSmallestInSortedMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {
        PriorityQueue<MatrixNode> minHeap = new PriorityQueue<MatrixNode>((n1,n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

        for(int i = 0 ; i < matrix[0].length ; i++) {
            minHeap.add(new MatrixNode(i,0));
        }

        int smallestElementCount = 0, result = 0;

        while(!minHeap.isEmpty()) {
            MatrixNode node = minHeap.poll();
            result = matrix[node.row][node.col];

            if(++smallestElementCount == k)
                break;

            node.col++;

            if(matrix[node.row].length > node.col) {
                minHeap.add(node);
            }
        }
        //System.out.println(matrix[2].length);
        //System.out.println(matrix[0][2]);
        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } , { 5, 8, 11 }};
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
