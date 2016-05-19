package me.wayne.sort;

import java.util.Arrays;
import java.util.List;


public class TestSort {

    private static final Integer[] ARRAY =
            {98, 76, 109, 34, 67, 190, 80, 12, 14, 89, 1, 23, 33, 65, 567, 233, 190, 12};

    public static void sort() {
        System.out.println();

        List<Integer> data = Arrays.asList(ARRAY);
        System.out.println("raw data :\n" + data.toString());

    }


}