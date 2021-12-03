package com.example.leetcodeserver.question.stack;

import com.example.leetcodeserver.untils.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NNryTreePreorderTraversal589 {
    public static void main(String[] args) {
        NNryTreePreorderTraversal589 postorderTraversal559 = new NNryTreePreorderTraversal589();
        postorderTraversal559.preorder(new Node());
    }

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        //递归
//        preorder(root, ans);

        //迭代:因为是根左右的方式，先把根放进去，然后每次pop出来时就先把根的值保存
        //然后需要将根下所有的节点保存斤stack，因为是先左再右，所以需要把跟节点下的节点反向push到栈中
//        if (root == null) return ans;
//        Stack<Node> stack = new Stack<>();
//        stack.add(root);
//        while (!stack.isEmpty()) {
//            Node node = stack.pop();
//            ans.add(node.val);
//            Collections.reverse(node.children);
//            stack.addAll(node.children);
//        }
        if (root == null) return ans;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);
            Collections.reverse(root.children);
            stack.addAll(root.children);
        }
        return ans;
    }

    private void preorder(Node root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        for (Node node : root.children) {
            preorder(node, ans);
        }
    }
}
