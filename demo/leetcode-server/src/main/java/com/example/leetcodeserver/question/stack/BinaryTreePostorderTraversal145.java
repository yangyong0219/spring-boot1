package com.example.leetcodeserver.question.stack;

import com.example.leetcodeserver.untils.TreeNode;

import java.util.*;

public class BinaryTreePostorderTraversal145 {
    public static void main(String[] args) {
        BinaryTreePostorderTraversal145 traversal145 = new BinaryTreePostorderTraversal145();
        traversal145.postorderTraversal(new TreeNode());

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        //迭代，没什么说的
        List<Integer> ans = new ArrayList<>();
//        postorderTraversal(root, ans);

        //迭代,这个迭代有一点麻烦，但是和前序遍历和中序遍历是比较类似的
        //首先由于后续遍历的顺序是左右根，所以在访问根的时候一定要保证左右是访问过的
        //我们在前序遍历的时候，每次读到根就先把根保存，就完成了前序遍历
        //我们在中序遍历的时候，每次都是走到最左侧（也就是叶子节点也就是没有左右子树的根）然后再保存，之后去访问他的右子树
        //后序遍历的话，要保证保存数据时左右节点全部都保存过，由于我们一直是往左遍历的，所以当我们拿到一个数据的时候
        //一定能保证左边的数据已经遍历了，那么怎么判断右边的数据是否遍历呢，就是引入一个指针，指向已经遍历的右子树
        //所以每次拿到节点的时候先判断右子树是不是为空或者是不是遍历过，如果都满足，才保存，然后将指针指向当前节点，表示访问过
        //之后再将当前节点改为空，
//        if (root == null) {
//            return ans;
//        }
//        Deque<TreeNode> stack = new LinkedList<>();
//        TreeNode prev = null;
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (root.right == null || root.right == prev) {
//                ans.add(root.val);
//                prev = root;
//                root = null;
//            } else {
//                stack.push(root);
//                root = root.right;
//            }
//        }
//        return ans;

        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre) {
                ans.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return ans;
    }

    private void postorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        postorderTraversal(root.left, ans);
        postorderTraversal(root.right, ans);
        ans.add(root.val);
    }
}
