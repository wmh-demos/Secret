package me.wayne.leetcodetop100.dfs;

/**
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 */
public class LC200_NumIslands {

    public int numIslands(char[][] grid) {
        int island = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '1') {
                    island++;
                    dfs(grid, row, column);
                }
            }
        }

        return island;
    }

    private void dfs(char[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length
                || grid[row][column] != '1') {
            return;
        }

        grid[row][column] = '0';
        // left
        dfs(grid, row, column - 1);
        // right
        dfs(grid, row, column + 1);
        // top
        dfs(grid, row - 1, column);
        // bottom
        dfs(grid, row + 1, column);
    }
}
