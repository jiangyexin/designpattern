package com.jyx.algorithm;

/**
 * @author jiangyexin
 * @date 2021/7/14 16:56
 */
public class DpShares {

    public static void main(String[] args) {

    }

    /**
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * @param prices
     * @return
     */
    public  static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = prices[i] >= minPrice ? minPrice : prices[i];
            profit = prices[i] - minPrice > profit ? prices[i] - minPrice : profit;
        }
        return profit;
    }
}
