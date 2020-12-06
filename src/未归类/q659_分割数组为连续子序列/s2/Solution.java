package 未归类.q659_分割数组为连续子序列.s2;

/**
 * 贪心：
 */
class Solution {
    public boolean isPossible(int[] nums) {
        //dp1表示长度为一的序列，dp2表示长度为2，dp3表示长度>=3
        int dp1 = 0, dp2 = 0, dp3 = 0;
        int len = nums.length;
        int i = 0;
        while (i < len) {
            int start = i;
            int x = nums[i];
            while (i < len && nums[i] == x) {
                i++;
            }
            int cut = i - start;

            if (start > 0 && x != nums[start - 1] + 1) {
                if (dp1 + dp2 > 0) {
                    return false;
                }
                dp1 = cut;
                dp2 = dp3 = 0;
            } else {
                if (dp1 + dp2 > cut) {
                    return false;
                }
                int tmp = cut - dp1 - dp2;
                int keep = Math.min(dp3, tmp);
                dp3 = keep + dp2;
                dp2 = dp1;
                dp1 = tmp - keep;
            }
        }
        return dp1 == 0 && dp2 == 0;
    }
}