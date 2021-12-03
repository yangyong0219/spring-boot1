package com.example.leetcodeserver.question.recursion;

import com.example.leetcodeserver.untils.TreeNode;

public class MinimumDepthOfBinaryTree11 {
    public static void main(String[] args) {

    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int depth = Integer.MAX_VALUE;
        if(root.left!=null){
            depth = Math.min(minDepth(root.left), depth);
        }
        if(root.right!=null){
            depth = Math.max(minDepth(root.right), depth);
        }
        return depth+1;

    }
}
