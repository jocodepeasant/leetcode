package 柱状图.q84_柱状图中最大的矩形.s2;

import java.util.LinkedList;

/**
 * 单调栈：
 * 在暴力解法中，我们每一次都需要去求当前矩形的宽度，使用单调栈可以简略这一步，
 * 使用栈存储边的下标（方便获取宽度和高度），栈中元素单调递增，
 * 如果当前边小于栈顶边，则表示当前边为栈顶边构成矩形的右边界，
 * 其次，既然是递增单调栈，那么栈顶的第二个元素（如果有）即为左边界，
 * 这样一来以当前边为高度所构成矩形的宽度就确定了。
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            //弹出小于当前边的栈顶元素
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int idx = stack.pop();
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                res = Math.max(res, heights[idx] * width);
            }
            stack.push(i);
        }
        //栈中可能还存在元素，一个个弹出求其面积
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int width = stack.isEmpty() ? heights.length : heights.length - 1 - stack.peek();
            res = Math.max(res, heights[idx] * width);
        }
        return res;
    }
}