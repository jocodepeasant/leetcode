package 贪心算法.q316_去除重复字母.s1;

import java.util.LinkedList;

/**
 * 贪心算法+栈：
 * 给定一个字符串 s ，去除字符串中重复的字母，使每个字母只出现一次，要想获得其最小的字典序，
 * 我们要尽量保证比较小的值往前靠，那么，在满足条件下，什么情况才能往前靠？答案是：
 * s[i-1]>s[i] && cut[s[i-1]]>0，即前面字母大于当前字母并且s中还有前面的这一个字母。
 * 本解法中，我们采用栈来存储字典序，当满足上述情况时将字母弹出。
 */
class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        boolean[] inStack = new boolean[26];
        int[] cut = new int[26];
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            cut[chars[i] - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            cut[ch - 'a']--;
            //栈中已有该元素，栈顶元素肯定小于当前元素（大于会被弹出，见下面while循环）
            if (inStack[ch - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > ch && cut[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
            inStack[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}