package com.example.leetcodeserver.question.recursion;

import com.example.leetcodeserver.untils.TreeNode;

public class InvertBinaryTree226 {
    public static void main(String[] args) {
        InvertBinaryTree226 invertBinaryTree226 = new InvertBinaryTree226();
        invertBinaryTree226.invertTree(new TreeNode());
    }

    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return null;
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//        root.left = right;
//        root.right = left;
//        return root;

        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
