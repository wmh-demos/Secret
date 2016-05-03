package me.wayne.sort;

import java.util.List;

public class Bubble {

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
