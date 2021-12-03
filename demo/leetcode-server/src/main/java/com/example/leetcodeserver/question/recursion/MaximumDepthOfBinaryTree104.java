package com.example.leetcodeserver.question.recursion;

import com.example.leetcodeserver.untils.TreeNode;

public class MaximumDepthOfBinaryTree104 {
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree104 maximumDepthOfBinaryTree104 = new MaximumDepthOfBinaryTree104();
        int i = maximumDepthOfBinaryTree104.maxDepth(new TreeNode());
        System.out.println(i);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
