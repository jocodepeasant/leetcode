package 动态规划.q140_单词拆分II.s1;

import java.util.*;

/**
 *
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>();
        int len = s.length();
        int maxLen = 0;
        for (String word : wordDict) {
            wordSet.add(word);
            maxLen = Math.max(maxLen, word.length());
        }
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int right = 1; right < len + 1; right++) {
            for (int left = right - 1; left >= 0 && left>=right-maxLen; left--) {
                String suffix = s.substring(left, right);
                if (wordSet.contains(suffix) && dp[left]) {
                    dp[right] = true;
                }
            }
        }

        ArrayList<String> res = new ArrayList<>();
        if (dp[len]) {
            dfs(s, len, wordSet, dp, new ArrayDeque<String>(), res);
            return res;
        }
        return res;
    }

    private void dfs(String s, int len, Set<String> wordSet, boolean[] dp, ArrayDeque<String> path, List<String> res) {
        if (len == 0) {
            res.add(String.join(" ", path));
            return;
        }

        for (int i = len - 1; i >= 0; i--) {
            String suffix = s.substring(i, len);
            if (wordSet.contains(suffix) && dp[i]) {
                path.addFirst(suffix);
                dfs(s, i, wordSet, dp, path, res);
                path.removeFirst();
            }
        }
    }
}
