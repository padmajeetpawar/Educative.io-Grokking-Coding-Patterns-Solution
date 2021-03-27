package com.educative;

import java.util.*;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2 next;

    TreeNode2(int x) {
        val = x;
        left = right = next = null;
    }
};

class ConnectAllSiblings {
    public static void connect(TreeNode2 root) {
       if( root == null)
           return;
       Queue<TreeNode2> queue = new LinkedList<>();
       queue.offer(root);

       while (!queue.isEmpty()) {
           int levelSize = queue.size();
           for(int i = 0 ; i < levelSize ; i++) {
               TreeNode2 currentNode = queue.poll();

               if(currentNode.left != null)
                   queue.offer(currentNode.left);
               if(currentNode.right != null)
                   queue.offer(currentNode.right);

               if(queue.size() != 0){
                   currentNode.next = queue.element();
               }

           }

       }
    }

    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(12);
        root.left = new TreeNode2(7);
        root.right = new TreeNode2(1);
        root.left.left = new TreeNode2(9);
        root.right.left = new TreeNode2(10);
        root.right.right = new TreeNode2(5);
        ConnectAllSiblings.connect(root);

        // level order traversal of returned output using 'next' pointer
        TreeNode2 current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
