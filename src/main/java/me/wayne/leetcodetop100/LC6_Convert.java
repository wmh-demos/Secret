package me.wayne.leetcodetop100;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class LC6_Convert {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        // ans保存每一行的String
        List<List<Character>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>());
        }

        boolean ordinal = true;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            ans.get(index).add(ch);
            // 每次到底或者到顶是换个方向
            if (i != 0 && i % (numRows - 1) == 0) {
                ordinal = !ordinal;
            }
            if (ordinal) {
                index++;
            } else {
                index--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (List<Character> list : ans) {
            for (Character ch : list) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
