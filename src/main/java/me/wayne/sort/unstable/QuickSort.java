package me.wayne.sort.unstable;

import me.wayne.sort.SortUtils;

import java.util.List;
import java.util.Stack;


public class QuickSort {

    /**
     * 快速排序
     * 最差时间复杂度,O(n2),即每次partition的结果是为最大或最小的时候,相当于冒泡排序
     * 最好时间复杂度,O(n*log2n)(由T[n] = 2T[n/2] + O(n)推导出 其中O(n)为PARTITION()的时间复杂度)
     * 空间复杂度O(log2n)~O(n)
     * 思路:每次随机取一个基准数,并将数列分为两部分,一部分比基准数小,另一部分比基准数大
     * 再对两部分进行递归调用
     */
    public static void sort(List<Integer> data) {
//        quickSort(data, 0, data.size() - 1);
//        System.out.println(data.toString());
        nonRecursionSort(data);
        System.out.println(data.toString());
    }

    private static void quickSort(List<Integer> data, int start, int end) {
        int index = partition(data, start, end);
        if (index - start > 1) {
            quickSort(data, start, index - 1);
        }
        if (end - index > 1) {
            quickSort(data, index + 1, end);
        }
    }

    private static int partition(List<Integer> data, int start, int end) {
        int i = (start + end) / 2;
        //以中间的值为基准,先将中间的值与末尾的值交换
        SortUtils.swap(data, i, end);

        int index = start;
        for (i = start; i < end; i++) {
            //每次都和基准数比较,比基准数小就往前换
            if (data.get(i) < data.get(end)) {
                SortUtils.swap(data, i, index++);
            }
        }

        //将基准数换到正确的位置
        SortUtils.swap(data, index, end);
        return index;
    }

    private static void nonRecursionSort(List<Integer> data) {
        Stack<Integer> stack = new Stack<Integer>();

        int start = 0, end = data.size() - 1, partition;
        stack.push(start);
        stack.push(end);

        while (!stack.isEmpty()) {
            end = stack.pop();
            start = stack.pop();
            partition = partition(data, start, end);
            if (partition - start > 1) {
                stack.push(start);
                stack.push(partition - 1);
            }
            if (end - partition > 1) {
                stack.push(partition + 1);
                stack.push(end);
            }
        }

    }
}
