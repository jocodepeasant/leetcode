package 未归类.q34_在排序数组中查找元素的第一个和最后一个位置.s1;

/**
 * 细节是魔鬼
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n1 = -1, n2 = -1;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums.length == 0 || left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        n1 = left;
        left = 0;
        right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        n2 = left - 1;
        return new int[]{n1, n2};
    }
}