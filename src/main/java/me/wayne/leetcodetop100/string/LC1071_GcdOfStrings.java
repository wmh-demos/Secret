package me.wayne.leetcodetop100.string;

/**
 * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 * <p>
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 *
 * <a href="https://leetcode.cn/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75">字符串的最大公因子</a>
 */
public class LC1071_GcdOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            return str1;
        }
        StringBuilder sb = new StringBuilder();
        int index1 = 0, index2 = 0;
        while (index1 < str1.length() && index2 < str2.length()) {
            if (str1.charAt(index1) == str2.charAt(index2)) {
                sb.append(str1.charAt(index1));
                index1++;
                index2++;
            } else {
                break;
            }
        }

        String result = sb.toString();
        if (result.isEmpty()) {
            return "";
        }

        int resultLength = result.length();
        for (int i = result.length(); i > 0; i--) {
            if (str1.length() % i == 0 && str2.length() % i == 0) {
                break;
            } else {
                resultLength--;
            }
        }
        result = result.substring(0, resultLength);
        if (checkResult(str1, result) && checkResult(str2, result)) {
            return result;
        } else {
            return "";
        }
    }

    private boolean checkResult(String rawStr, String resultStr) {
        int count = rawStr.length() / resultStr.length();
        return rawStr.equals(resultStr.repeat(count));
    }
}
