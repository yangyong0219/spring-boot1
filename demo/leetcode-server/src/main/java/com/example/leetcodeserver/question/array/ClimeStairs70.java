package com.example.leetcodeserver.question.array;

public class ClimeStairs70 {
    public static void main(String[] args) {
        ClimeStairs70 climeStairs70 = new ClimeStairs70();
        int result = climeStairs70.climbStairs1(6);
        System.out.println(result);
    }

    public int climbStairs(int n) {
        //就是从1开始的斐波拉契数列 1 2 3 5 8 。。。

        //1. 暴力递归
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//        return climbStairs(n - 1) + climbStairs(n - 2);

        //2. 自底向上缓存在数组
//        int[] dp = new int[n];
//        dp[0] = 1;
//        dp[1] = 2;
//        for (int i = 2; i < n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n-1];

        //3. 自底向上不用数组
        int pre = 1;
        int next = 2;
        if (n == 1) return pre;
        if (n == 2) return next;
        int curr = 0;
        for (int i = 3; i <= n; i++) {
            curr = pre + next;
            pre = next;
            next = curr;
        }
        return curr;
    }

    public int climbStairs1(int n) {
        //就是从1开始的斐波拉契数列 1 2 3 5 8 。。。

        //1. 暴力递归

        //2. 自底向上缓存在数组


        //3. 自底向上不用数组
        return 0;
    }


}
