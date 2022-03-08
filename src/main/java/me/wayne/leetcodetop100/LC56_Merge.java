package me.wayne.leetcodetop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]
 * 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 */
public class LC56_Merge {
    public int[][] merge(int[][] intervals) {
        // 将所有的数组下标为0的元素进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // 前一对
            int[] pre = ans.get(ans.size() - 1);
            // 当前一对
            int[] cur = intervals[i];
            if (pre[1] >= cur[0]) {
                pre[1] = Math.max(pre[1], cur[1]);
            } else {
                ans.add(cur);
            }
        }

        return ans.toArray(new int[0][]);
    }
}
