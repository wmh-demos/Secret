package me.wayne.leetcodetop100;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * https://leetcode-cn.com/problems/jump-game/
 */
public class LC55_CanJump {

    public boolean canJump(int[] nums) {
        int jump = 0;
        for (int i = 0; i <= jump; i++) {
            jump = Math.max(jump, i + nums[i]);
            if (jump >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
