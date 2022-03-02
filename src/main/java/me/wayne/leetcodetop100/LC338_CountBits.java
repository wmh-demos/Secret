package me.wayne.leetcodetop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
 * 返回一个长度为 n + 1 的数组 ans 作为答案。
 * <p>
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class LC338_CountBits {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        Arrays.fill(res, 0);

        List<Integer> targetList = getTargetList(n);
        for (int i = 0; i <= n; i++) {
            for (Integer target : targetList) {
                if ((i & target) == target) {
                    int value = res[i];
                    res[i] = ++value;
                }
            }
        }
        return res;
    }

    /**
     * 求出比n小的二进制比较位的列表
     * 如n=17时，列表中有1、2、4、8、16
     */
    private List<Integer> getTargetList(int n) {
        List<Integer> targetList = new ArrayList<>();
        int target = 0;
        while (Math.pow(2, target) <= n) {
            targetList.add((int) Math.pow(2, target));
            target++;
        }
        return targetList;
    }
}
