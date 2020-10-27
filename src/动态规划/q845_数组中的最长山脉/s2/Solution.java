package 动态规划.q845_数组中的最长山脉.s2;

import java.util.Arrays;

/**
 * 动态规划：
 * 定义两个数组dp1和dp2,dp1从左往右计算包含i的连续递增序列长度，dp2从右往左计算包含i的连续递增序列长度，以i为山顶时山脉的长度l=
 * {
 * dp1[i]=0 || dp2[i]=0 , 0
 * 其他 ， dp1[i]+dp2[i]
 * }
 *
 * @author fzb
 * @date 2020/10/26 13:30
 */
//TODO 完成一半
public class Solution {
    //直观
    public int longestMountain(int[] A) {
        int res = 0;
        int len = A.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for (int i = 1; i < len; i++) {
            if (A[i] > A[i - 1]) {
                dp1[i] += dp1[i - 1];
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                dp2[i] += dp2[i + 1];
            }
        }
        for (int i = 1; i < len - 1; i++) {
            if (dp1[i] != 1 && dp2[i] != 1) {
                res = Math.max(res, dp1[i] + dp2[i] - 1);
            }
        }
        return res;
    }

    //另一种写法
    public int longestMountain1(int[] A) {
        int res = 0;
        int len = A.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        for (int i = 1; i < len; i++) {
            if (A[i] > A[i - 1]) {
                dp1[i] = dp1[i - 1] + 1;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                dp2[i] = dp2[i + 1] + 1;
            }
        }
        for (int i = 1; i < len - 1; i++) {
            if (dp1[i] != 0 && dp2[i] != 0) {
                res = Math.max(res, dp1[i] + dp2[i] + 1);
            }
        }
        return res;
    }
}
