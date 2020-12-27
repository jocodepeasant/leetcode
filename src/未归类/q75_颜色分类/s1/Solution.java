package 未归类.q75_颜色分类.s1;

import java.util.Arrays;

/**
 * 计数排序
 */
public class Solution {
    public void sortColors(int[] nums) {
        int[] cut = new int[3];
        for (int i :
                nums) {
            cut[i]++;
        }
        Arrays.fill(nums, 0, cut[0], 0);
        Arrays.fill(nums, cut[0], cut[1] + cut[0], 1);
        Arrays.fill(nums, cut[1] + cut[0], nums.length, 2);
    }
}
