package me.wayne.leetcodetop100;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class LC8_MyAtoi {

    public int myAtoi(String s) {
        int i = 0, len = s.length();
        //skip space before string
        while (i < len) {
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                break;
            }
        }

        int result = 0;
        boolean negative = false;
        int digit;
        int multmin;
        int limit = -Integer.MAX_VALUE;
        if (i < len) {
            char firstChar = s.charAt(i);
            // Possible leading "+" or "-"
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+') {
                    return 0;
                }
                i++;
                if (len == i) {
                    return 0;
                }
            }

            multmin = limit / 10;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++), 10);
                if (digit < 0) {
                    return negative ? result : -result;
                }
                if (result < multmin) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result *= 10;
                if (result < limit + digit) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result -= digit;
            }
        } else {
            return 0;
        }

        return negative ? result : -result;
    }
}
