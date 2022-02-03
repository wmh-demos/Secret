package me.wayne.leetcodetop100.dp;

/**
 * 给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]
 * 现在让你用这个背包装物品，最多能装的价值是多少？
 * 推导dp[i][j]
 * 不放物品i：由dp[i - 1][j]推出，即背包容量为j，里面不放物品i的最大价值，此时dp[i][j]就是dp[i - 1][j]。
 * (其实就是当物品i的重量大于背包j的重量时，物品i无法放进背包中，所以被背包内的价值依然和前面相同。)
 * <p>
 * 放物品i：由dp[i - 1][j - weight[i]]推出，dp[i - 1][j - weight[i]] 为背包容量为j - weight[i]的时候不放物品i的最大价值，
 * 那么dp[i - 1][j - weight[i]] + value[i] （物品i的价值），就是背包放物品i得到的最大价值
 * <p>
 * dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
 * <p>
 * leetcode上没有原题，这是最经典的0-1背包问题，是理解背包系列问题的基础
 */
public class Knapsack {

    public static void main() {
        int[] values = {4, 2, 3};
        int[] weights = {2, 1, 3};
        System.out.println("max value == " + Knapsack.solution(4, values, weights));
    }

    @SuppressWarnings("SameParameterValue")
    private static int solution(int totalWeight, int[] val, int[] wt) {
        int n = val.length;
        // 定义dp数组：dp[i][j]表示背包容量为j时，容纳前i个物品能获得的最大价值
        int[][] dp = new int[n + 1][totalWeight + 1];
        for (int i = 0; i < n + 1; i++) {//遍历物品
            for (int w = 0; w < totalWeight + 1; w++) {//背包容量
                if (i == 0) {
                    // 初始化多余的第0行，值均为0
                    dp[0][w] = 0;
                } else if (w == 0) {
                    // 背包容量为0时，能获得的价值都为0
                    dp[i][0] = 0;
                } else {
                    if (w < wt[i - 1]) {
                        // 背包容量无法装下第i-1个商品，价值与dp[i - 1][w]相同
                        dp[i][w] = dp[i - 1][w];
                    } else {
                        // 背包可以装下第i-1个商品，判断装与不装哪个价值高
                        dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]] + val[i - 1], dp[i - 1][w]);
                    }
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < totalWeight + 1; j++) {
                System.out.print(dp[i][j] + "\t");
                if (j == totalWeight) {
                    System.out.println();
                }
            }
        }

        return dp[n][totalWeight];
    }
}
