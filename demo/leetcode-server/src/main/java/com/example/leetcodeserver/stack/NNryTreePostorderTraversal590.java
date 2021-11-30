package com.example.leetcodeserver.stack;

import com.example.leetcodeserver.untils.Node;

import java.util.*;

public class NNryTreePostorderTraversal590 {
    public static void main(String[] args) {
        NNryTreePostorderTraversal590 postorderTraversal559 = new NNryTreePostorderTraversal590();
        postorderTraversal559.postorder(new Node());
    }

    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }

    private void postorder(Node root, List<Integer> ans) {
        if (root == null) return;
        for (Node node : root.children) {
            postorder(node, ans);
        }
        ans.add(root.val);
    }
}
