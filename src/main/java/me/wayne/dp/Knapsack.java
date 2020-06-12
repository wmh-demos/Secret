package me.wayne.dp;

/**
 * 给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]
 * 现在让你用这个背包装物品，最多能装的价值是多少？
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
        int[][] dp = new int[n + 1][totalWeight + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int w = 0; w < totalWeight + 1; w++) {
                if (i == 0) {
                    dp[0][w] = 0;
                } else if (w == 0) {
                    dp[i][0] = 0;
                } else {
                    if (w < wt[i - 1]) {
                        dp[i][w] = dp[i - 1][w];
                    } else {
                        dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]]
                                + val[i - 1], dp[i - 1][w]);
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
