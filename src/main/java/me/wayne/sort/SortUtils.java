package me.wayne.sort;

import java.util.List;

public class SortUtils {

    public static void swap(List<Integer> data, int i, int j) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}
