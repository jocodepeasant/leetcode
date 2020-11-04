package 未归类.q57_插入区间.s2;

import java.util.ArrayList;

/**
 * 双指针
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] res = new int[1][2];
            res[0] = newInterval;
            return res;
        }
        int left = 0, right = intervals.length - 1;
        ArrayList<int[]> res = new ArrayList<>();
        while (left < intervals.length && intervals[left][1] < newInterval[0]) {
            res.add(intervals[left]);
            left++;
        }
        while (right >= 0 && intervals[right][0] > newInterval[1]) {
            res.add(left, intervals[right]);
            right--;
        }
        int[] tmp = new int[2];
        tmp[0] = left < intervals.length ? Math.min(newInterval[0], intervals[left][0]) : newInterval[0];
        tmp[1] = right >= 0 ? Math.max(newInterval[1], intervals[right][1]) : newInterval[1];
        res.add(left, tmp);
        int[][] arr = new int[res.size()][2];
        return res.toArray(arr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = new int[][]{{2, 5}, {6, 7}, {8, 9}};
        int[] b = new int[]{0, 1};
        solution.insert(a, b);
    }
}