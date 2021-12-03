package com.example.leetcodeserver.question.recursion;

public class ClimbingStairs70 {
    public static void main(String[] args) {
        ClimbingStairs70 climbingStairs70 = new ClimbingStairs70();
        int i = climbingStairs70.climbStairs(7);
        System.out.println(i);
    }

    public int climbStairs(int n) {
        //这道题就是一个从1，2开始的斐波拉契数列 1,2,3,5,8,13,21
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        return climbStairs(n, dp);

        //只保留前两个数字法
//        int pre = 1;
//        int next = 2;
//        int ans = 0;
//        for (int i = 3; i <= n; i++) {
//            ans = pre + next;
//            pre = next;
//            next = ans;
//        }
//        return ans;

    }

    private int climbStairs(int n, int[] dp) {
        //自顶向下递归
//        if (dp[n]!=0) {
//            return dp[n];
//        }
//        dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
//        return dp[n];

        //自底向上
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
