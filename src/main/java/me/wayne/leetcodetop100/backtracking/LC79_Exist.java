package me.wayne.leetcodetop100.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC79_Exist {

    public boolean exist(char[][] board, String word) {
        List<List<Integer>> positions = getCharPosition(board, word.charAt(0));
        if (positions.isEmpty()) {
            return false;
        }
        if (word.length() == 1) {
            return true;
        }

        boolean[][] visited = new boolean[board.length][];
        for (int i = 0; i < visited.length; i++) {
            boolean[] arr = new boolean[board[0].length];
            Arrays.fill(arr, false);
            visited[i] = arr;
        }

        List<String> ans = new ArrayList<>();
        for (List<Integer> position : positions) {
            StringBuilder path = new StringBuilder();
            visited[position.get(0)][position.get(1)] = true;
            dfs(ans, path, board, word.substring(1), position, visited);

            if (!ans.isEmpty()) {
                break;
            }

            for (boolean[] booleans : visited) {
                Arrays.fill(booleans, false);
            }
        }

        return !ans.isEmpty();
    }

    private List<List<Integer>> getCharPosition(char[][] board, char ch) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                if (ch == chars[j]) {
                    List<Integer> result = new ArrayList<>();
                    result.add(i);
                    result.add(j);
                    ans.add(result);
                }
            }
        }

        return ans;
    }

    private void dfs(List<String> ans, StringBuilder path, char[][] board, String word,
            List<Integer> pos,
            boolean[][] visited) {
        if (word.length() == 0) {
            ans.add(path.toString());
            return;
        }

        //0往左，1往上，2往右，3往下
        for (int i = 0; i < 4; i++) {
            int column = pos.get(0);
            int row = pos.get(1);
            if (i == 0) {
                row -= 1;
            } else if (i == 1) {
                column -= 1;
            } else if (i == 2) {
                row += 1;
            } else {
                column += 1;
            }
            if (column < 0 || column >= board.length) {
                continue;
            }
            if (row < 0 || row >= board[0].length) {
                continue;
            }
            if (visited[column][row]) {
                continue;
            }
            if (board[column][row] != word.charAt(0)) {
                continue;
            }

            path.append(word.charAt(0));
            visited[column][row] = true;
            String nextWord = word.substring(1);

            List<Integer> nextPos = new ArrayList<>();
            nextPos.add(column);
            nextPos.add(row);
            dfs(ans, path, board, nextWord, nextPos, visited);

            visited[column][row] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }
}
