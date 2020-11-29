package 回溯算法.q51_N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯：
 * n*n棋盘的对角线有规律，同一对角线（左上对角线相减为同一值，右上对角线相加为同一值）取值有规律，
 * 可以定义两个2*n-1的数组标志能否被攻击。
 */
class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[] row = new boolean[n];
        boolean[] d1 = new boolean[2 * n - 1];
        boolean[] d2 = new boolean[2 * n - 1];
        backTrack(n, 0, row, d1, d2, new ArrayList<String>());

        return res;
    }

    private void backTrack(int n, int i, boolean[] row, boolean[] d1, boolean[] d2, ArrayList<String> tmp) {
        for (int j = 0; j < n; j++) {
            if (row[j] || d1[n + j - i - 1] || d2[i + j]) {
                continue;
            }
            row[j] = true;
            d1[n + j - i - 1] = true;
            d2[i + j] = true;
            char[] c = new char[n];
            Arrays.fill(c, '.');
            c[j] = 'Q';
            tmp.add(new String(c));
            if (i == n - 1) {
                res.add(new ArrayList<>(tmp));
            } else {
                backTrack(n, i + 1, row, d1, d2, tmp);
            }
            row[j] = false;
            d1[n + j - i - 1] = false;
            d2[i + j] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
