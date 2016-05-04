package me.wayne.sort.stable;

import java.util.List;

import me.wayne.sort.SortUtils;

public class InsertionSort {

    /**
     * 插入排序,稳定
     * 时间复杂度O(n2)
     * 空间复杂度O(1)
     */
    public static void sort(List<Integer> data) {
        for (int i = 1; i < data.size(); i++) {
            for (int j = i - 1; j >= 0 && data.get(j) > data.get(j + 1); j--) {
                SortUtils.swap(data, j, j + 1);
            }
        }
        System.out.println(data.toString());
    }
}
