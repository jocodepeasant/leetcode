package 并查集.q959_由斜杠划分区域.s2;

class Solution {
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] newGrid = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    newGrid[i * 3][j * 3 + 2] = 1;
                    newGrid[i * 3 + 1][j * 3 + 1] = 1;
                    newGrid[i * 3 + 2][j * 3] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    newGrid[i * 3][j * 3] = 1;
                    newGrid[i * 3 + 1][j * 3 + 1] = 1;
                    newGrid[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 3 * n; i++) {
            for (int j = 0; j < 3 * n; j++) {
                if (newGrid[i][j] == 0) {
                    backTrack(newGrid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void backTrack(int[][] newGrid, int i, int j) {
        if (inArea(i, j, newGrid) && newGrid[i][j] == 0) {
            newGrid[i][j] = 1;
            for (int k = 0; k < 4; k++) {
                int newI = i + dir[k][0];
                int newJ = j + dir[k][1];
                backTrack(newGrid, newI, newJ);
            }
        }
    }

    private boolean inArea(int i, int j, int[][] newGrid) {
        return i >= 0 && j >= 0 && i < newGrid.length && j < newGrid[0].length;
    }
}
