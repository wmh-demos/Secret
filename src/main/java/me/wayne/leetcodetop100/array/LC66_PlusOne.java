package me.wayne.leetcodetop100.array;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 链接：https://leetcode-cn.com/problems/plus-one
 */
public class LC66_PlusOne {
    public int[] plusOne(int[] digits) {
        boolean plusOne = false;//表示当前是否需要进一位
        for (int i = digits.length - 1; i >= 0; i--) {
            int value = digits[i];
            //最后一位，加1
            if (i == digits.length - 1) {
                value++;
            }

            //如果要进位，加1
            if (plusOne) {
                value++;
                plusOne = false;
            }

            //当前位最终变成2位数了，plusOne置为true
            if (value >= 10) {
                plusOne = true;
            }
            // 将值更新回数组
            digits[i] = value % 10;
        }
        if (!plusOne) {
            return digits;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 1; i < digits.length; i++) {
            result[i] = digits[i - 1];
        }
        return result;
    }
}
