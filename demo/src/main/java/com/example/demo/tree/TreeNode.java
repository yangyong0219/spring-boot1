package com.example.demo.tree;

public class TreeNode {
    int data;
    TreeNode leftTree;
    TreeNode rightTree;

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", leftTree=" + leftTree +
                ", rightTree=" + rightTree +
                '}';
    }

    public TreeNode(Integer data) {
        this.data = data;
    }
}
