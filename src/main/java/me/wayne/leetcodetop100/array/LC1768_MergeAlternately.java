package me.wayne.leetcodetop100.array;

/**
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * <p>
 * 返回 合并后的字符串 。
 * <a href="https://leetcode.cn/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75">交替合并字符串</a>
 */
public class LC1768_MergeAlternately {

    public String mergeAlternately(String word1, String word2) {
        int index1 = 0;
        int index2 = 0;
        boolean chooseFirst = true;
        StringBuilder result = new StringBuilder();
        while (index1 < word1.length() || index2 < word2.length()) {
            if (chooseFirst) {
                result.append(word1.charAt(index1++));
            } else {
                result.append(word2.charAt(index2++));
            }
            if (index1 < word1.length() && index2 < word2.length()) {
                chooseFirst = !chooseFirst;
            } else if (index1 < word1.length()) {
                chooseFirst = true;
            } else {
                chooseFirst = false;
            }
        }
        return result.toString();
    }
}
