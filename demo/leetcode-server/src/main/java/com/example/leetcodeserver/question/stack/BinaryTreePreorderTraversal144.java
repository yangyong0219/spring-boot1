package com.example.leetcodeserver.question.stack;

import com.example.leetcodeserver.untils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
    public static void main(String[] args) {
        BinaryTreePreorderTraversal144 binaryTreePreorderTraversal144 = new BinaryTreePreorderTraversal144();
        binaryTreePreorderTraversal144.preorderTraversal(new TreeNode());


    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //递归，递归是简单的不能再简单的算法
//        preorderTraversal(root, ans);

        //迭代，这个思想和树的中序遍历是一致的，唯一不同的是，中序遍历是遍历到最左侧也就是最左的一个节点才保存，而前序遍历由于是根左右，所以每次将左子节点放到栈的时候就保存
        //为什么要一直顺着左子树走呢？ 因为跟后面不是右  而是根左右
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }


        return ans;
    }

    private void preorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        preorderTraversal(root.left, ans);
        preorderTraversal(root.right, ans);
    }


}
