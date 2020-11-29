package 回溯算法.q47_全排列II.s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTrack(nums, visited, res, 0, new LinkedList<>());
        return res;
    }

    private void backTrack(int[] nums, boolean[] visited, List<List<Integer>> res, int cut, LinkedList<Integer> tmp) {
        if (cut == nums.length) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]){
                if (i>0 && nums[i]==nums[i-1] && !visited[i-1]) continue;
                visited[i] = true;
                tmp.push(nums[i]);
                backTrack(nums, visited, res, cut + 1, tmp);
                visited[i] = false;
                tmp.pop();
            }
        }
    }
}
