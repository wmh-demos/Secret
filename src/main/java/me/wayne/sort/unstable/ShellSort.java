package me.wayne.sort.unstable;

import me.wayne.sort.SortUtils;

import java.util.List;


public class ShellSort {

    /**
     * 希尔排序, 改进版的插入排序
     * 时间复杂度,最坏O(n2),最好O(n*log2n)(n*(lgn平方))
     * 思路:把待排序元素分为几个区域,这样可以让一个元素一次性朝最终位置前进一大步
     * 然后算法取越来越小的部长,最后一步就是普通的插入排序了
     */
    public static void sort(List<Integer> data) {
        int i, j, gap;
        for (gap = data.size() / 2; gap > 0; gap /= 2) {
            for (i = gap; i < data.size(); i++) {
                for (j = i; j >= gap && data.get(j - gap) > data.get(j); j -= gap) {
                    SortUtils.swap(data, j - gap, j);
                }
            }
        }
        System.out.println(data.toString());
    }
}
