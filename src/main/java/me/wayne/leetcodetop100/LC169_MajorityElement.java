package me.wayne.leetcodetop100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * https://leetcode-cn.com/problems/majority-element/
 */
public class LC169_MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            Integer value = map.get(num);
            map.put(num, value == null ? 1 : ++value);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                result = entry.getKey();
                break;
            }
        }

        return result;
    }
}
