package me.wayne.sort.stable;

import java.util.List;

import me.wayne.sort.SortUtils;

public class BubbleSort {

    /**
     * 冒泡排序,稳定
     * 时间复杂度O(n2)
     * 空间复杂度O(1)
     */
    public static void sort(List<Integer> data) {
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(i) > data.get(j)) {
                    SortUtils.swap(data, i, j);
                }
            }
        }

        System.out.println(data.toString());
    }
}
