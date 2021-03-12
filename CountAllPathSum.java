package com.educative;

import java.util.*;

class CountAllPathSum {
    public static int countPaths(TreeNode root, int S) {
        List<Integer> currentPath = new LinkedList<>();
        return countPathsRecursive(root, S, currentPath);
    }

    private static int countPathsRecursive(TreeNode root, int s, List<Integer> currentPath) {
        if(root == null)
            return 0;
        currentPath.add(root.val);
        int pathSum = 0; int pathCount = 0;
        ListIterator<Integer> itr = currentPath.listIterator(currentPath.size());

        while(itr.hasPrevious()) {
            pathSum += itr.previous();

            if(pathSum == s)
                pathCount++;
        }

        pathCount += countPathsRecursive(root.left, s, currentPath);
        pathCount += countPathsRecursive(root.right, s, currentPath);

        currentPath.remove(currentPath.size() - 1);

        return pathCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
