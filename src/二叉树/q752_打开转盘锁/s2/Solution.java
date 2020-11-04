package 二叉树.q752_打开转盘锁.s2;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 双向BFS
 */
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));
        int res = 0;
        HashSet<String> q1 = new HashSet<>();
        HashSet<String> q2 = new HashSet<>();
        if (visited.contains("0000")) {
            return -1;
        }
        q1.add("0000");
        q2.add(target);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            HashSet<String> tmp = new HashSet<>();
            for (String cur : q1) {
                if (q2.contains(cur)) {
                    return res;
                }
                visited.add(cur);
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        tmp.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        tmp.add(down);
                    }
                }
            }
            res++;
            q1 = q2;
            q2 = tmp;
        }
        return -1;
    }

    private String plusOne(String cur, int idx) {
        int n = cur.charAt(idx) - '0';
        StringBuilder stringBuilder = new StringBuilder(cur);
        stringBuilder.setCharAt(idx, (char) ((n + 1) % 10 + '0'));
        return stringBuilder.toString();
    }

    private String minusOne(String cur, int idx) {
        int n = cur.charAt(idx) - '0';
        StringBuilder stringBuilder = new StringBuilder(cur);
        if (n == 0) {
            stringBuilder.setCharAt(idx, (char) (9 + '0'));
        } else {
            stringBuilder.setCharAt(idx, (char) ((n - 1) % 10 + '0'));
        }
        return stringBuilder.toString();
    }
}