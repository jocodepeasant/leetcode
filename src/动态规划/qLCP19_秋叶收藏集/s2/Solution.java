package 动态规划.qLCP19_秋叶收藏集.s2;

/**
 * 平时自练地
 */
public class Solution {
    //使用数组states[i][j]来表示从0-i片叶子对应的i种状态的最少调整数（红、红黄、红黄红）
    public int minimumOperations(String leaves) {
        //对应三个状态的最少调整数（红、红黄、红黄红）
        int[][] states = new int[leaves.length()][3];
        //初始化，第一片叶子必为红色
        states[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        states[0][1] = states[0][2] = states[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < leaves.length(); i++) {
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            states[i][0] = states[i - 1][0] + isYellow;
            states[i][1] = Math.min(states[i - 1][1], states[i - 1][0]) + isRed;
            if (i >= 2) {
                states[i][2] = Math.min(states[i - 1][1], states[i - 1][2]) + isYellow;
            }
        }
        return states[leaves.length() - 1][2];
    }
}
