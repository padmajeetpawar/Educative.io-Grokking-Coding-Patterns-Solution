package com.educative;

import java.util.*;

class RightViewTree {
    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0 ; i < levelSize ; i++) {
                TreeNode currentNode = queue.poll();
                if(queue.size() == 0 && !result.contains(currentNode))
                    result.add(currentNode);

                if(currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                    result.add(currentNode.right);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightViewTree.traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}

