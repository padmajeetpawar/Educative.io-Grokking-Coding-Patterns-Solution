package com.educative;

import java.util.*;

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1 next;

    TreeNode1(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    public void printLevelOrder() {
        TreeNode1 nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNode1 current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
};

class ConnectLevelOrderSiblings {
    public static void connect(TreeNode1 root) {
        if (root == null)
            return;
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode1 previousNode = null;

            for( int i = 0 ; i < levelSize ; i++) {
                TreeNode1 current = queue.poll();
                if(previousNode != null)
                    previousNode.next = current;
                previousNode = current;

                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(9);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
