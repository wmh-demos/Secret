package me.wayne.sort.stable;


import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    /**
     * 归并排序,稳定
     * 时间复杂度O(n*log2n)
     * 空间复杂度O(n)
     */
    public static List<Integer> sort(List<Integer> data) {
        if (data.size() > 1) {
            int halfSize = data.size() / 2;
            List<Integer> data1 = sort(new ArrayList<Integer>(data.subList(0, halfSize)));
            List<Integer> data2 = sort(new ArrayList<Integer>(data.subList(halfSize, data.size())));
            return mergeArray(data1, data2);
        } else {
            return data;
        }
    }

    private static List<Integer> mergeArray(List<Integer> data1, List<Integer> data2) {
        List<Integer> data = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < data1.size() && j < data2.size()) {
            if (data1.get(i) < data2.get(j)) {
                data.add(data1.get(i++));
            } else {
                data.add(data2.get(j++));
            }
        }
        while (i < data1.size()) {
            data.add(data1.get(i++));
        }
        while (j < data2.size()) {
            data.add(data2.get(j++));
        }
        return data;
    }
}
