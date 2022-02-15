package me.wayne.leetcodetop100.dp;

/**
 * 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 */
public class LC121_MaxProfit {

    public int maxProfit(int[] prices) {
        // dp[i]表示截止到i，价格最低点是多少 dp[i] = min(dp[i - 1], prices[i])
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            res = Math.max(res, prices[i] - dp[i]);
        }
        return Math.max(0, res);
    }
}
