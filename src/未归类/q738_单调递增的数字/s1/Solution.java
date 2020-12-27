package 未归类.q738_单调递增的数字.s1;

/**
 * 贪心：从右往左遍历
 */
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int len = chars.length;
        for (int i = len - 1; i > 0; i--) {
            if (chars[i] < chars[i - 1]) {
                chars[i - 1]--;
                for (int j = i; j < len; j++) {
                    chars[j] = '9';
                }
            }
        }
        return Integer.valueOf(String.valueOf(chars));
    }
}