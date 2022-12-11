package me.wayne.leetcodetop100.twopointers;

/**
 * <p>
 * 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">最长回文子串</a>
 * <p>
 * 中心扩展法：
 * 在一次循环过程中，选择一个中心，进行左右扩展，判断字符是否相等
 * 需要注意奇数和偶数字串判断的区别，因此需要判断两次
 */
public class LC5_LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        String result = "";//用于保存结果字串，每次遇到更长的就更新
        for (int i = 0; i < s.length() - 1; i++) {
            int length1 = getPalindromeLength(s, i, i);//求出长度为奇数的回文子串
            int length2 = getPalindromeLength(s, i, i + 1);//求出长度为偶数的回文子串
            int length = Math.max(length1, length2);
            int left = i - (length - 1) / 2;
            int right = i + length / 2;
            String palindrome = s.substring(left, right + 1);
            if (palindrome.length() > result.length()) {
                result = palindrome;
            }
        }

        return result;
    }

    private int getPalindromeLength(String s, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex <= s.length() - 1
                && s.charAt(leftIndex) == s.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }
        return rightIndex - leftIndex - 1;
    }
}
