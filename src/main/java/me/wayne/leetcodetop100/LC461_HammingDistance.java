package me.wayne.leetcodetop100;

/**
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * https://leetcode-cn.com/problems/hamming-distance/
 */
public class LC461_HammingDistance {

    public int hammingDistance(int x, int y) {
        int value = x ^ y;
        int res = 0;
        while (value != 0) {
            if ((value & 1) == 1) {
                res++;
            }
            value = value / 2;
        }
        return res;
    }
}
