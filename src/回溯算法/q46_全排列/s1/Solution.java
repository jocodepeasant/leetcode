package 回溯算法.q46_全排列.s1;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯：
 * 使用visited数组标记已被访问过的数字。
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums, new boolean[nums.length],new ArrayList<Integer>());
        return res;
    }

    private void backTrack(int[] nums, boolean[] visited,ArrayList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            tmp.add(nums[i]);
            backTrack(nums, visited, tmp);
            visited[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
