package 二叉树.q752_打开转盘锁.s1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 */
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        int res = 0;
        Queue<String> queue = new LinkedList<>();
        if (set.contains("0000")) {
            return 0;
        }
        queue.offer("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (cur.equals(target)) {
                    return res;
                }
                set.add(cur);
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!set.contains(up)) {
                        queue.offer(up);
                        set.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!set.contains(down)) {
                        queue.offer(down);
                        set.add(down);
                    }
                }
            }
            res++;
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] s = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        System.out.println(solution.openLock(s, "8888"));
    }
}