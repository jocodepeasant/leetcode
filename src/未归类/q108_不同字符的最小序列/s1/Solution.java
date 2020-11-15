package 未归类.q108_不同字符的最小序列.s1;

import java.util.Stack;

/**
 * 贪心：
 * 这道题的关键是“局部最优”，即新来的的单词要比前面的单词字典序要大，即要永远保持前面字符的字典序越小越好。
 * 由于均为小写字符，本题解中使用位掩码的方式做标志。
 */
public class Solution {
    public String smallestSubsequence(String text) {
        int len = text.length();
        //位掩码，存储从i到len-1出现的字符
        int[] post = new int[len];
        //位掩码，存储已出现的字符
        int pre = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                post[i] |= (1 << (text.charAt(j) - 'a'));
            }
        }
        for (int i = 0; i < len; i++) {
            int c = text.charAt(i) - 'a';
            if ((pre & (1 << c)) > 0) {
                continue;
            }
            while (!stack.empty() && c < stack.peek() &&
                    (post[i] & (1 << stack.peek())) != 0) {
                Integer pop = stack.pop();
                pre ^= (1 << pop);
            }
            pre |= (1 << c);
            stack.push(c);
        }
        StringBuilder res = new StringBuilder();
        for (int c : stack) {
            res.append((char) (c + 'a'));
        }
        return res.toString();
    }
}