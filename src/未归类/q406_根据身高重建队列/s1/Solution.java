package 未归类.q406_根据身高重建队列.s1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            } else {
                return y[0] - x[0];
            }
        });
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]);
    }
}