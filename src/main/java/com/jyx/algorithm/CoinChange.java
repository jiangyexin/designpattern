package com.jyx.algorithm;

/**
 * 零钱兑换问题
 * https://leetcode-cn.com/problems/coin-change/
 * @author jiangyexin
 * @date 2021/8/13 15:08
 */
public class CoinChange {
    int count = 0;

    /**
     * 能列出所有满足条件的情况，但是 没有去除重复解，比如 122,212,221
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        StringBuilder s = new StringBuilder();
        change(0, coins,amount);
        return count;
    }

    private void change(int curAmount, int[] coins, int amount) {
        if (curAmount >= amount || curAmount < 0) {
            if (curAmount == amount) {
                count++;
            }
            return;
        }
        for (int coin : coins) {
            change(curAmount + coin, coins, amount);
        }
    }

    /**
     * 动态规划
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeDp(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            dp[i] = min;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        /*[1,2147483647] 2*/
        CoinChange coinChange = new CoinChange();
        int[] coins = {1,2,5};
        coinChange.coinChange(coins,5);
    }


}
