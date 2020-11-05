package 未归类.q127_单词接龙.s2;

import java.util.HashSet;
import java.util.List;

/**
 * 双向BFS
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        HashSet<String> visited = new HashSet<>();
        HashSet<String> queue1 = new HashSet<>();
        HashSet<String> queue2 = new HashSet<>();
        visited.add(beginWord);
        queue1.add(beginWord);
        queue2.add(endWord);
        int res = 1;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.size() > queue2.size()) {
                HashSet nextWord = queue1;
                queue1 = queue2;
                queue2 = nextWord;
            }
            HashSet<String> nextQueue = new HashSet<>();
            for (String cur : queue1) {
                char[] curChar = cur.toCharArray();
                for (int i = 0; i < curChar.length; i++) {
                    char c = curChar[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        curChar[i] = j;
                        String nextWord = String.valueOf(curChar);
                        if (wordSet.contains(nextWord)) {
                            if (queue2.contains(nextWord)) {
                                return res + 1;
                            }
                            if (!visited.contains(nextWord)) {
                                nextQueue.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    curChar[i] = c;
                }
            }
            queue1 = nextQueue;
            res++;
        }
        return 0;
    }
}