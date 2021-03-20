package com.example.demo.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TestTree {
    public TreeNode createTreeNode(List<Integer> inputList) {
        TreeNode treeNode = null;
        if (inputList == null || inputList.isEmpty()) {
            return treeNode;
        }
        Integer data = inputList.remove(0);
        if (data != null) {
            treeNode = new TreeNode(data);
            treeNode.leftTree = createTreeNode(inputList);
            treeNode.rightTree = createTreeNode(inputList);
        }
        return treeNode;
    }

    public void preTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.data);
        preTree(treeNode.leftTree);
        preTree(treeNode.rightTree);
    }

    public void midTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        midTree(treeNode.leftTree);
        System.out.println(treeNode.data);
        midTree(treeNode.rightTree);
    }

    public void lastTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        lastTree(treeNode.leftTree);
        lastTree(treeNode.rightTree);
        System.out.println(treeNode.data);
    }

    public List<Integer> preTreeWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                ans.add(treeNode.data);
                stack.push(treeNode.rightTree);
                treeNode = treeNode.leftTree;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
            }
        }
        return ans;
    }

    public List<Integer> midTreeWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.leftTree;
            }
            root = stack.pop();
            ans.add(root.data);
            root = root.rightTree;
        }
        return ans;
    }

    public List<Integer> lastTreeWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                ans.add(root.data);
                stack.push(root.leftTree);
                root = root.rightTree;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TestTree testTree = new TestTree();
        TreeNode treeNode = testTree.createTreeNode(new ArrayList<Integer>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4)));
//        System.out.println(treeNode);
//        testTree.preTree(treeNode);
//        testTree.midTree(treeNode);
//        testTree.lastTree(treeNode);
        System.out.println(testTree.preTreeWithStack(treeNode));
        System.out.println(testTree.midTreeWithStack(treeNode));
        System.out.println(testTree.lastTreeWithStack(treeNode));
    }
}
