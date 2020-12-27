package 贪心算法.q84_柱状图中最大的矩形.s3;

import java.util.LinkedList;

/**
 * 单调栈+哨兵：
 * 思路和前面大致一样，有如下改动：
 * a、在数组左边加入高度为零的边，入栈作为哨兵，避免了每次都需要对栈进行判空
 * b、在数组右边加入高度为零的边，保证所有heights中的所有边在遍历完都能弹出栈，简化代码
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        //哨兵
        stack.push(0);
        int res = 0;
        for (int i = 1; i < newHeights.length; i++) {
            while (newHeights[stack.peek()] > newHeights[i]) {
                int idx = stack.pop();
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                res = Math.max(res, newHeights[idx] * width);
            }
            stack.push(i);
        }
        return res;
    }
}