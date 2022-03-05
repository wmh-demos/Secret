package me.wayne.leetcodetop100;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * https://leetcode-cn.com/problems/rotate-image/
 */
public class LC48_Rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 借助辅助空间找规律，第一行复制到最后一列，第二行在倒数第二列
        int[][] tempMatrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                tempMatrix[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            System.arraycopy(tempMatrix[i], 0, matrix[i], 0, n);
        }
    }
}