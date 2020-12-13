package 未归类.q861_翻转矩阵后的得分.s1;

/**
 * 贪心算法：
 * 保证第一列都是1，其他列要有尽量多的1。
 */
class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int res = (1 << (n - 1)) * m;
        for (int j = 1; j < n; j++) {
            int tmp = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][0] == 1) {
                    tmp += A[i][j];
                } else {
                    tmp += 1 - A[i][j];
                }
            }
            int t = Math.max(tmp, m - tmp);
            res += (1 << (n - 1 - j)) * t;
        }
        return res;
    }
}