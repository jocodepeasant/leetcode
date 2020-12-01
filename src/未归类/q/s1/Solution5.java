package 未归类.q.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * 平时自练地
 */
class Solution5 {
    public List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        int idx = 0;
        int right = map[S.charAt(idx) - 'a'];
        ArrayList<Integer> res = new ArrayList<>();
        int begin = 0;
        while (idx < S.length()) {
            if (idx == right) {
                res.add(right - begin + 1);
                idx++;
                begin = idx;
                if (idx < S.length()) {
                    right = map[S.charAt(idx) - 'a'];
                }
            } else {
                if (map[S.charAt(idx) - 'a'] > right) {
                    right = map[S.charAt(idx) - 'a'];
                }
                idx++;
            }
        }
        return res;
    }
}
