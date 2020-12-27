package 未归类.q738_单调递增的数字.s2;

/**
 * 贪心：从左往右，较解法一耗时少一点
 */
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > chars[i + 1]) {
                int tmp = i;
                for (; tmp < chars.length; tmp++) {
                    chars[tmp] = '9';
                }
                tmp = i;
                while (tmp > 0 && chars[tmp] == chars[tmp - 1]) {
                    chars[tmp--] = '9';
                }
                chars[tmp] -= 1;
            }
        }
        return Integer.valueOf(String.valueOf(chars));
    }
}