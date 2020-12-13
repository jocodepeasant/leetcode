package 未归类.q842_将数组拆分成斐波那契序列.s1;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法
 */
class Solution {
    private List<Integer> res = new LinkedList<>();

    public List<Integer> splitIntoFibonacci(String S) {
        backTrack(S, 0, new LinkedList<Integer>());
        return res;
    }

    private boolean backTrack(String s, int idx, LinkedList<Integer> tmp) {
        if (idx == s.length()) {
            return tmp.size() >= 3;
        }
        long num = 0;
        for (int i = idx; i < s.length(); i++) {
            if (i > idx && s.charAt(idx) == '0') {
                return false;
            }
            num = 10 * num + s.charAt(i) - '0';
            if (num > Integer.MAX_VALUE) {
                return false;
            }
            if (tmp.size() >= 2 && num != tmp.get(tmp.size() - 1) + tmp.get(tmp.size() - 2)) {
                continue;
            } else {
                tmp.add((int) num);
                if (backTrack(s, i + 1, tmp)) {
                    res = tmp;
                    return true;
                }
                tmp.remove(tmp.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.splitIntoFibonacci("11235813");
    }
}