package me.wayne.sort.unstable;

import me.wayne.sort.SortUtils;

import java.util.List;


public class SelectionSort {

    /***
     * 选择排序,
     * 时间复杂度O(n2), 空间复杂度O(1)
     * 思路:每次寻找找到一个最大或最小的值,交换位置
     */
    public static void sort(List<Integer> data) {
        int i, j, min;
        for (i = 0; i < data.size(); i++) {
            min = i;
            for (j = i + 1; j < data.size(); j++) {
                if (data.get(j) < data.get(min)) {
                    min = j;
                }
            }
            if (min != i) {
                SortUtils.swap(data, i, min);
            }
        }
        System.out.println(data.toString());
    }

}
