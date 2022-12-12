package me.wayne.leetcodetop100;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * <p>
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 */
public class LC9_IsPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int raw = x;
        int tmp = 0;
        while (x > 0) {
            tmp = tmp * 10 + x % 10;
            x = x / 10;
        }
        return raw == tmp;
    }
}
