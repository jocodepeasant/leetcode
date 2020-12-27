package 未归类.q108_不同字符的最小序列.s2;

import java.util.LinkedList;

/**
 * 与s1的基本思路一样，与s1不同的是，s1采用位掩码做标志，这里使用cut和visited来分别表示剩下字符数和字符是否选择且未被删除，
 * 将时间复杂度降为O(N)。
 */
public class Solution {
    public String smallestSubsequence(String text) {
        int len = text.length();
        int[] cut = new int[26];
        LinkedList<Character> stack = new LinkedList<>();
        boolean[] visited = new boolean[26];
        for (char c : text.toCharArray()) {
            cut[c - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            cut[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            //比栈顶元素小并且后面还有当前字符，弹出。
            while (!stack.isEmpty() && stack.peek() > c &&
                    cut[stack.peek()-'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}