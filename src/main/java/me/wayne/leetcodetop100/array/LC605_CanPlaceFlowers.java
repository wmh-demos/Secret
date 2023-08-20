package me.wayne.leetcodetop100.array;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 *
 * <a href="https://leetcode.cn/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75">种花问题</a>
 */
public class LC605_CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            return n == 0 || flowerbed[0] == 0;
        }

        int canPlace = 0;
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                if (flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                    //第0个位置只判断第1个位置的情况
                    flowerbed[i] = 1;
                    canPlace++;
                }
            } else if (i == length - 1) {
                if (flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
                    //最后一个位置，只判断倒数第二个的位置
                    flowerbed[i] = 1;
                    canPlace++;
                }
            } else {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    canPlace++;
                }
            }
        }
        return canPlace >= n;
    }
}