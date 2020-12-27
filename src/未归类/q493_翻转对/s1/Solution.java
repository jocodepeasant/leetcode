package 未归类.q493_翻转对.s1;

/**
 * 归并排序
 */
class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return reversePairsRecursive(nums, 0, nums.length - 1);
    }

    private int reversePairsRecursive(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int n1 = reversePairsRecursive(nums, left, mid);
        int n2 = reversePairsRecursive(nums, mid + 1, right);
        int res = n1 + n2;

        //计算左右两边的翻转对数量
        int l = left, r = mid + 1;
        while (l <= mid) {
            while (r <= right && (long) nums[l] > (long) 2 * nums[r]) {
                r++;
            }
            res += r - mid - 1;
            l++;
        }

        //排序
        l = left;
        r = mid + 1;
        int idx = 0;
        int[] sorted = new int[right - left + 1];
        while (l <= mid || r <= right) {
            if (l > mid) {
                sorted[idx++] = nums[r++];
            } else if (r > right) {
                sorted[idx++] = nums[l++];
            } else {
                if (nums[l] < nums[r]) {
                    sorted[idx++] = nums[l++];
                } else {
                    sorted[idx++] = nums[r++];
                }
            }
        }
        for (int i = 0; i < sorted.length; i++) {
            nums[i + left] = sorted[i];
        }
        return res;
    }
}