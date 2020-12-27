package 未归类.q416_分割等和子集.s2;

import java.util.HashMap;

/**
 * 递归，记忆化
 */
class Solution {
    HashMap<String, Boolean> memo = new HashMap<String, Boolean>();

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
        if (idx == nums.length || target < 0) {
            return false;
        }
        String key = idx + " " + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        boolean res = helper(idx + 1, nums, target) || helper(idx + 1, nums, target - nums[idx]);
        memo.put(key, res);
        return res;
    }
}
