package me.wayne.sort.stable;

import me.wayne.sort.SortUtils;

import java.util.List;

public class InsertionSort {

    /**
     * 插入排序,稳定
     * 时间复杂度O(n2)
     * 空间复杂度O(1)
     * 思想:将一个数从后往前插入到一个有序序列中,只要这个数比有序序列的小,就交换位置
     * 两重循环,时间复杂度O(n2)
     */
    public static void sort(List<Integer> data) {
        for (int i = 1; i < data.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (data.get(j - 1) > data.get(j)) {
                    SortUtils.swap(data, j - 1, j);
                }
            }
        }
        System.out.println(data);
    }
}
