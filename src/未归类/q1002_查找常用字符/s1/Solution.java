package 未归类.q1002_查找常用字符.s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路：本题是找出字符串数组中每个字符串都出现的字符(包括重复字符)，因此我们需要对出现的字符进行计数，这里使用两个整型数组分别存储前一次的当前的相同字母出现次数，
 */
class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
        int[] pre = new int[26];
        int[] cur = new int[26];
        //初始化
        Arrays.fill(pre, Integer.MAX_VALUE);
        for (String s :
                A) {
            cur = new int[26];
            char[] ch = s.toCharArray();
            for (char c :
                    ch) {
                int n = c - 'a';
                //最多只能与前一次的出现次数相同
                if (pre[n] > cur[n]) {
                    cur[n]++;
                }
            }
            pre = cur;
        }
        for (int i = 0; i < cur.length; i++) {
            for (int j = 0; j < cur[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }
}
