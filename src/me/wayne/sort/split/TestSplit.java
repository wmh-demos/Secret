package me.wayne.sort.split;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestSplit {

    private static final int PAGE_SIZE = 4 * 2;

    public static void main(String[] args) {
        int i = 100;
        List<List<Integer>> list = new ArrayList<>();
        for (int index = 0; index < i; index++) {
            list.add(new ArrayList<>());
        }
        for (int index = 0; index < i; index++) {
            Random random = new Random();
            int r = random.nextInt(100);
            for (int n = 0; n < r; n++) {
                list.get(index).add(n);
            }
        }

        for (List<Integer> source : list) {
            List<List<Integer>> result = splitList(source, PAGE_SIZE);
            System.out.println("result : " + result);
        }
    }


    private static <T> List<List<T>> splitList(List<T> list, int pageSize) {
        List<List<T>> listArray = new ArrayList<>();
        List<T> subList = null;
        for (int i = 0; i < list.size(); i++) {
            if (i % pageSize == 0) {
                subList = new ArrayList<>();
                listArray.add(subList);
            }
            if (subList != null) {
                subList.add(list.get(i));
            }
        }
        return listArray;
    }
}
