package me.wayne.leetcodetop100.dp;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * <p>
 * 转换为0-1背包问题。
 * 思路：求出数组和的一半，定义一个数据dp[i][j]
 * dp[i][j] = x 表示，对于前 i 个物品，当前背包的容量为 j 时
 * 若 x 为 true，则说明可以恰好将背包装满，反之无法恰好将背包装满
 * <p>
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class LC416_CanPartition {

    private static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        sum = sum / 2;
        //dp[i][j] = x 表示，对于前 i 个物品，当前背包的容量为 j 时，若 x 为 true，
        // 则说明可以恰好将背包装满，若 x 为 false，则说明不能恰好将背包装满。
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j < nums[i - 1]) {
                    //背包容量不足，不能装入第i个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //装入或者不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][sum];
    }
}
