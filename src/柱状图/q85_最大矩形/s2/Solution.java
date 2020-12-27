package 柱状图.q85_最大矩形.s2;

import java.util.LinkedList;

/**
 * 单调栈
 * 解法二的思路与84.柱状图中最大的矩形的解法类似，
 * 只是二维和一维的区别，对于每一行，在计算其列的高度后，我们可以将其看做与84的一样的柱状图，
 * 使用栈存储列下标，栈中元素单调递增，
 * 如果当前列高度小于栈顶的列高度，则表示当前列为栈顶列构成矩形的右边界，
 * 其次，既然是递增单调栈，那么栈顶的第二个元素（如果有）即为左边界，
 * 这样一来以当前列高度所构成矩形的宽度就确定了。
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] heights = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[i][j] = i > 0 ? heights[i - 1][j] + 1 : 1;
                }
            }
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //弹出比当前列高度小的栈顶元素，计算以其为高度所构成矩形的面积
                while (!stack.isEmpty() && heights[i][stack.peek()] > heights[i][j]) {
                    Integer idx = stack.pop();
                    int width = stack.isEmpty() ? j : j - stack.peek() - 1;
                    res = Math.max(res, heights[i][idx] * width);
                }
                stack.push(j);
            }
            //可能还有元素未弹出
            while (!stack.isEmpty()) {
                Integer idx = stack.pop();
                int width = stack.isEmpty() ? n : n - stack.peek() - 1;
                res = Math.max(res, heights[i][idx] * width);
            }
        }
        return res;
    }
}