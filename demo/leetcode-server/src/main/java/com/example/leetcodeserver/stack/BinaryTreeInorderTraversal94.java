package com.example.leetcodeserver.stack;

import com.example.leetcodeserver.untils.TreeNode;

import java.util.*;

public class BinaryTreeInorderTraversal94 {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal94 binaryTreeInorderTraversal94 = new BinaryTreeInorderTraversal94();
        List<Integer> ans = new ArrayList<>();
        binaryTreeInorderTraversal94.inorderTraversal(new TreeNode());

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
//        inorderTraversal(root, res);

        //迭代法可以理解：
        //第一层while 只要跟节点不为空或者是栈不为空就要进去循环，简单理解为只要树还没遍历完以及栈中还有节点就需要继续遍历
        //然后将树的左节点循环保存到栈中，当循环到最边上到时候其实这就是一个没有子节点的跟节点，然后将跟节点拿出来保存起来
//        //由于中序遍历的顺序是左根右  当根节点已经放进去后，只需要再继续遍历右子树即可
//        Deque<TreeNode> stk = new LinkedList<>();
//        while (root != null || !stk.isEmpty()) {
//            while (root != null) {
//                stk.push(root);
//                root = root.left;
//            }
//            root = stk.pop();
//            res.add(root.val);
//            root = root.right;
//        }
//        return res;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public void inorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        inorderTraversal(root.left, ans);
        ans.add(root.val);
        inorderTraversal(root.right, ans);
    }

}
