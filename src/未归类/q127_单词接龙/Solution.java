package 未归类.q127_单词接龙;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        HashSet<String> set = new HashSet<>(wordList);
        if (set.size() == 0 || !set.contains(endWord)) {
            return 0;
        }
        set.remove(beginWord);
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] cur = queue.poll().toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    char originChar = cur[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == originChar) {
                            continue;
                        }
                        cur[j] = k;
                        String nextWord = String.valueOf(cur);
                        if (set.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return res+1;
                            }
                            if (!visited.contains(nextWord)) {
                                queue.offer(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    cur[j] = originChar;
                }
            }
            res++;
        }
        return 0;
    }
}