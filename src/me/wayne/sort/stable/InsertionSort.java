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
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (data.get(j - 1) > data.get(j))
                SortUtils.swap(data, j - 1, j);
            }
        }
        System.out.println(data.toString());
    }
}
