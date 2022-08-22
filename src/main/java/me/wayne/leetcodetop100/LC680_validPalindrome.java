package me.wayne.leetcodetop100;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * <a href="https://leetcode.cn/problems/valid-palindrome-ii/">链接</a>
 */
class LC680_validPalindrome {

   public boolean validPalindrome(String s) {
      if (s == null || "".equals(s)) {
         return false;
      }

      int head = 0, tail = s.length() - 1;
      while (head < tail) {
         if (s.charAt(head) == s.charAt(tail)) {
            head++;
            tail--;
         } else {
            return isInvalid(s, head + 1, tail) || isInvalid(s, head, tail - 1);
         }
      }
      return true;
   }

   public boolean isInvalid(String s, int start, int end) {
      while(start < end) {
         if (s.charAt(start) != s.charAt(end)) {
            return false;
         } else {
            start++;
            end--;
         }
      }
      return true;
   }
}
