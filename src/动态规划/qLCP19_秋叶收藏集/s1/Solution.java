package 动态规划.qLCP19_秋叶收藏集.s1;

/**
 * 平时自练地
 */
public class Solution {
    //使用数组states[j]来表示从0-i片叶子对应的i种状态的最少调整数（红、红黄、红黄红）
    public int minimumOperations(String leaves) {
        //对应三个状态的最少调整数（红、红黄、红黄红）
        int[] states = new int[3];
        //初始化，第一片叶子必为红色
        states[0] = leaves.charAt(0) == 'y' ? 1 : 0;
        states[1] =states[2] = Integer.MAX_VALUE;
        for (int i = 1; i < leaves.length(); i++) {
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            if (i >= 2) {
                states[2] = Math.min(states[1], states[2]) + isYellow;
            }
            states[1] = Math.min(states[1], states[0]) + isRed;
            states[0] = states[0] + isYellow;
        }
        return states[2];
    }
}
