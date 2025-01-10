package com.jyx;

public class TestDp {
    public static void main(String[] args) {
        int num = climbStairs(10);
        System.out.println(""+num);
    }
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
               dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
}
