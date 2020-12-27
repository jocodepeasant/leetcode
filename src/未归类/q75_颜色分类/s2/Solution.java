package 未归类.q75_颜色分类.s2;

/**
 * 未描述
 */
public class Solution {
    public void sortColors(int[] nums) {
        int cur = 0, left = 0, right = nums.length - 1;
        while (cur <= right) {
            if (nums[cur] == 0) {
                swap(cur, left, nums);
                left++;
                cur++;
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(cur, right, nums);
                right--;
            }
        }
    }

    private void swap(int x, int y, int[] nums) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
