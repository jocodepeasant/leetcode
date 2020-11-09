package 未归类.q57_插入区间.s1;

import java.util.ArrayList;

/**
 * 单指针
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        ArrayList<int[]> res = new ArrayList<>();
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        int[][] arr = new int[res.size()][2];
        return res.toArray(arr);
    }
}