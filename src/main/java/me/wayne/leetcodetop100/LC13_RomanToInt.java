package me.wayne.leetcodetop100;

/**
 * <a href="https://leetcode-cn.com/problems/roman-to-integer/">落马数字转整形</a>
 */
public class LC13_RomanToInt {

    public int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char next = '0';
            if (i + 1 < s.length()) {
                next = s.charAt(i + 1);
            }

            if ('M' == ch) {
                ans += 1000;
            } else if ('D' == ch) {
                ans += 500;
            } else if ('C' == ch) {
                if ('M' == next) {
                    ans += 900;
                    i++;
                } else if ('D' == next) {
                    ans += 400;
                    i++;
                } else {
                    ans += 100;
                }
            } else if ('L' == ch) {
                ans += 50;
            } else if ('X' == ch) {
                if ('C' == next) {
                    ans += 90;
                    i++;
                } else if ('L' == next) {
                    ans += 40;
                    i++;
                } else {
                    ans += 10;
                }
            } else if ('V' == ch) {
                ans += 5;
            } else if ('I' == ch) {
                if ('X' == next) {
                    ans += 9;
                    i++;
                } else if ('V' == next) {
                    ans += 4;
                    i++;
                } else {
                    ans += 1;
                }
            }
        }
        return ans;
    }
}
