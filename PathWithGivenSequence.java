package com.educative;


class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] arr) {
        return findPathRecursive(root,arr,0);
    }

    private static boolean findPathRecursive(TreeNode root, int[] arr, int i) {
        if(root == null)
            return false;


        if(i >= arr.length || root.val != arr[i]) {
            return false;
        }

        if(i == arr.length - 1 && root.left == null && root.right == null){
            return true;
        }

        return findPathRecursive(root.left,arr,i+1) || findPathRecursive(root.right,arr,i+1);


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6}));
    }
}