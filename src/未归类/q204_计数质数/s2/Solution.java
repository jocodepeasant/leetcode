package 未归类.q204_计数质数.s2;

import java.util.ArrayList;

/**
 * 暴力优化，加list存储遍历过的质数
 */
class Solution {
    public int countPrimes(int n) {
        ArrayList<Integer> tmp = new ArrayList<>();
        int res = 0;
        for (int i = 2; i < n; i++) {
            boolean bol = true;
            for (int idx = 0; idx < tmp.size(); idx++) {
                if (tmp.get(idx) * tmp.get(idx) > i) {
                    break;
                }
                if (i % tmp.get(idx) == 0) {
                    bol = false;
                    break;
                }
            }
            if (bol) {
                res++;
                tmp.add(i);
            }
        }
        return res;
    }
}