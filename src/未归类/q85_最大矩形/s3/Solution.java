package 未归类.q85_最大矩形.s3;

import java.util.LinkedList;

/**
 * 单调栈+哨兵
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[] heights = new int[n + 2];
        //初始化
        heights[0] = -1;
        heights[n + 1] = -1;
        int res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        //哨兵
        stack.push(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j + 1] = heights[j + 1] + 1;
                } else {
                    heights[j + 1] = 0;
                }
            }
            for (int j = 1; j < n + 2; j++) {
                while (heights[stack.peek()] > heights[j]) {
                    Integer idx = stack.pop();
                    int width = j - stack.peek() - 1;
                    res = Math.max(res, heights[idx] * width);
                }
                stack.push(j);
            }
            //弹出最后一个元素
            stack.pop();
        }
        return res;
    }
}