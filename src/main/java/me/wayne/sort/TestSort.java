package me.wayne.sort;

import me.wayne.sort.stable.BubbleSort;
import me.wayne.sort.stable.InsertionSort;
import me.wayne.sort.unstable.SelectionSort;

import java.util.Arrays;

public class TestSort {

    private static final Integer[] ARRAY1 =
            {98, 76, 109, 34, 67, 190, 80, 12, 14, 89, 1, 23, 33, 65, 567, 233, 190, 12};
    private static final Integer[] ARRAY2 = {1, 6, 7, 2, 3, 4, 5};

    public static void sort() {
        BubbleSort.sort(Arrays.asList(ARRAY1));
        BubbleSort.sort(Arrays.asList(ARRAY2));

        SelectionSort.sort(Arrays.asList(ARRAY1));
        SelectionSort.sort(Arrays.asList(ARRAY2));

        InsertionSort.sort(Arrays.asList(ARRAY1));
        InsertionSort.sort(Arrays.asList(ARRAY2));

//        System.out.println(MergeSort.sort(Arrays.asList(ARRAY1)));
//        System.out.println(MergeSort.sort(Arrays.asList(ARRAY2)));

//        QuickSort.sort(Arrays.asList(ARRAY1));
//        QuickSort.sort(Arrays.asList(ARRAY2));

//        HeapSort.sort(Arrays.asList(ARRAY1));
//        HeapSort.sort(Arrays.asList(ARRAY2));
    }
}