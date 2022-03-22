package me.wayne.leetcodetop100;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围[−2的31次方, 2的31次方− 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 */
public class LC7_Reverse {

    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        // 这里十分巧妙，通过long强转为int后是否相等来判断有没有溢出
        return (int) n == n ? (int) n : 0;
    }
}
