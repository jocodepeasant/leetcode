package 未归类.q959_由斜杠划分区域.s1;

/**
 * 把每一个网格分为3*3的小网格，设置一个boolean数组bol[3*len][3*len]，填入\或/，
 * 有填到的小网格置为true，全部填完之后，遍历，不为true的话区域+1，
 * 并且将附近不为true的小网格置为true，直到网格本身为true或超出数组范围。
 */
class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int regionsBySlashes(String[] grid) {
        int len = grid.length;
        boolean[][] bol = new boolean[3 * len][3 * len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '\\') {
                    bol[i * 3][j * 3] = true;
                    bol[i * 3 + 1][j * 3 + 1] = true;
                    bol[i * 3 + 2][j * 3 + 2] = true;
                } else if (ch == '/') {
                    bol[i * 3 + 2][j * 3] = true;
                    bol[i * 3 + 1][j * 3 + 1] = true;
                    bol[i * 3][j * 3 + 2] = true;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 3 * len; i++) {
            for (int j = 0; j < 3 * len; j++) {
                if (!bol[i][j]) {
                    res++;
                    dfs(bol, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(boolean[][] bol, int i, int j) {
        if (!bol[i][j]) {
            bol[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int ni = i + dir[k][0];
                int nj = j + dir[k][1];
                if (ni >= 0 && ni < bol.length && nj >= 0 && nj < bol.length) {
                    dfs(bol, ni, nj);
                }
            }
        }
    }
}
