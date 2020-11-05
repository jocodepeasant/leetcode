package 未归类.q127_单词接龙.s1;

import java.util.*;

/**
 * BFS
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(beginWord);
        queue.offer(beginWord);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                char[] cur = queue.poll().toCharArray();
                for (int i = 0; i < cur.length; i++) {
                    char curCh = cur[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        cur[i] = j;
                        String tmp = String.valueOf(cur);
                        if (wordSet.contains(tmp)) {
                            if (endWord.equals(tmp)) {
                                return res + 1;
                            }
                            if (!visited.contains(tmp)) {
                                queue.offer(tmp);
                                visited.add(tmp);
                            }
                        }
                    }
                    cur[i]=curCh;
                }
            }
            res++;
        }
        return 0;
    }
}