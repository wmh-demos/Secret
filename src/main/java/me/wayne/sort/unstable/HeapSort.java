package me.wayne.sort.unstable;

import me.wayne.sort.SortUtils;

import java.util.List;


public class HeapSort {

    /**
     * 堆排序,不稳定
     * 时间复杂度O(n*log2n)
     * 空间复杂度O(1)
     * 思路:从最后一个非终端节点建一个大顶堆
     * 然后依次将堆顶元素放到最后再重新调整堆
     */
    public static void sort(List<Integer> data) {

        //从最后一个非终端结点开始建大顶堆
        int i;
        for (i = data.size() / 2 - 1; i >= 0; i--) {
            maxHeapFix(data, i, data.size() - 1);
        }

        //不断的将最大的数挪到最后一个,然后再第0个数开始调整堆
        for (i = data.size() - 1; i >= 1; i--) {
            SortUtils.swap(data, i, 0);
            maxHeapFix(data, 0, i - 1);
        }
        System.out.println(data);
    }

    /***
     * @param start 堆调整起始位置
     * @param end 堆调整结束位置
     * 堆调整函数,给定起始和结束位置
     */
    private static void maxHeapFix(List<Integer> data, int start, int end) {
        for (int son = start * 2 + 1; son <= end; start = son, son = son * 2 + 1) {
            if (son + 1 <= end && data.get(son + 1) > data.get(son)) {
                //获取两个子结点中较大的结点的引用
                son++;
            }

            //判断子结点与父结点大小
            if (data.get(son) > data.get(start)) {
                //将子结点挪到父结点
                SortUtils.swap(data, son, start);
            }
        }
    }
}
