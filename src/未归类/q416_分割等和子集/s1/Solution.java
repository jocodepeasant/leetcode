package 未归类.q416_分割等和子集.s1;

/**
 * 递归，超时
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int cut = 0;
        for (int i :
                nums) {
            cut += i;
        }
        if ((cut & 1) != 0) {
            return false;
        }
        return helper(0, nums, cut / 2);
    }

    private boolean helper(int idx, int[] nums, int target) {
        if (target == 0) {
            return true;
        }
        if (idx == nums.length) {
            return false;
        }
        return helper(idx + 1, nums, target) || helper(idx + 1, nums, target - nums[idx]);
    }
}
