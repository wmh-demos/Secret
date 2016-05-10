package me.wayne.sort.unstable;

import java.util.List;

import me.wayne.sort.SortUtils;

public class HeapSort {

    /**
     * 堆排序,不稳定
     * 时间复杂度O(n*log2n)
     * 空间复杂度O(1)
     */
    public static void sort(List<Integer> data) {

        //从最后一个非终端结点开始建堆
        int i;
        for (i = data.size() / 2 - 1; i >= 0; i--) {
            maxHeapFix(data, data.size(), i);
        }

        //不断的将最大的数挪到最后一个,然后再第0个数开始调整堆
        for (i = data.size() - 1; i >= 1; i--) {
            SortUtils.swap(data, i, 0);
            maxHeapFix(data, i, 0);
        }
        System.out.println(data.toString());
    }

    /***
     * @param index 堆调整起始位置
     * @param len 堆调整结束位置
     * 堆调整函数,给定起始和结束位置
     */
    private static void maxHeapFix(List<Integer> data, int len, int index) {
        int dadValue = data.get(index);
        int son = index * 2 + 1;
        while (son < len) {
            if (son + 1 < len && data.get(son + 1) > data.get(son)) {
                //获取两个子结点中较大的结点的引用
                son++;
            }

            //判断子结点与父结点大小
            if (data.get(son) < dadValue) {
                break;
            }

            //将子结点挪到父结点
            data.set(index, data.get(son));
            index = son;
            son = son * 2 + 1;
        }
        data.set(index, dadValue);
    }
}
