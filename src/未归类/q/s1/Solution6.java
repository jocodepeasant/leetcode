package 未归类.q.s1;

import java.util.ArrayList;
import java.util.List;

class Solution6 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> splitIntoFibonacci(String S) {
        int len = S.length();
        backTrack(S, new ArrayList<>(), 0);
        return res;
    }

    private boolean backTrack(String s, ArrayList<Integer> tmp, int idx) {
        if (idx == s.length() && tmp.size() >= 3) {
            return true;
        }
        for (int i = idx + 1; i <= s.length(); i++) {
            if (i-idx > 1 && s.charAt(idx) - '0' == 0) {
                return false;
            }
            long num = Long.valueOf(s.substring(idx, i));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = tmp.size();
            if (size < 2 || tmp.get(size - 1) + tmp.get(size - 2) == num) {
                tmp.add((int) num);
                if (backTrack(s, tmp, i)) {
                    res = tmp;
                    return true;
                }
                tmp.remove(tmp.size() - 1);
            }
        }
        return false;
    }
}