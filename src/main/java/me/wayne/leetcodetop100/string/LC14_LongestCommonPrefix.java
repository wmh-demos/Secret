package me.wayne.leetcodetop100.string;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class LC14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if (result.equals("")) {
                break;
            }

            String target = strs[i];
            int len1 = result.length();
            int len2 = target.length();
            int len = Math.min(len1, len2);
            result = result.substring(0, len);
            for (int j = 0; j < len; j++) {
                if (result.charAt(j) != target.charAt(j)) {
                    result = result.substring(0, j);
                    break;
                }
            }
        }

        return result;
    }
}
