package 回溯算法.q46_全排列.s2;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯：
 * 在当前数组中进行元素交换，不需要额外空间。
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums, 0);
        return res;
    }

    private void backTrack(int[] nums, int idx) {
        if (idx == nums.length) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int n : nums) {
                tmp.add(n);
            }
            res.add(tmp);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            backTrack(nums, idx + 1);
            swap(nums, i, idx);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
