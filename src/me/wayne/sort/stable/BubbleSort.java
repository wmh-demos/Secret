package me.wayne.sort.stable;

import java.util.List;

import me.wayne.sort.SortUtils;

public class BubbleSort {

    /**
     * 冒泡排序,稳定
     * 时间复杂度O(n2)
     * 空间复杂度O(1)
     * 思想:两重循环,两两比较,每次小的数放到前面,一次循环下来找到最小的数,是为冒泡
     * 再依次递归,两重循环,时间复杂度O(n2)
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