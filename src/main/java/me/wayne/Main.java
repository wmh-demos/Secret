package me.wayne;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello IntelliJ!!!");
        int[] nums = new int[]{1, 2, 3};
        int mid = nums.length / 2;
        int[] leftArr =  Arrays.copyOfRange(nums, 0, mid);
        int[] rightArr = Arrays.copyOfRange(nums, mid + 1, nums.length);
        System.out.println(Arrays.toString(leftArr));
        System.out.println(Arrays.toString(rightArr));
    }
}
