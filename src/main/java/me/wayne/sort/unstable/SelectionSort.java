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
        //外层循环
        for (int i = 0; i < data.size(); i++) {
            int max = 0;
            //内层循环
            for (int j = 0; j < data.size() - i; j++) {
                //找出单次遍历最大的下标
                if (data.get(j) > data.get(max)) {
                    max = j;
                }
                //单次遍历到最后，交换最后与最大值
                if (j == data.size() - i - 1) {
                    SortUtils.swap(data, max, j);
                }
            }
        }
        System.out.println(data);
    }

}
