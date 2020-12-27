package 贪心算法.q321_拼接最大数.s1;

/**
 * 分治+贪心：
 * 要得到最大数，那么两个数组也必须是最大数，将问题分成求两个数组的最大数，再将其合并。
 * 贪心：求数组最大数，我们要保证数组的左边尽量的大，才能保证为最大数。
 */
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - len1); i <= k && i <= len2; i++) {
            //获取两个数组在当前选择长度下的最大数，合并
            int[] tmp = merge(maxArr(nums1, k - i), maxArr(nums2, i));
            //与当前最大数比较
            if (compare(tmp, 0, res, 0)) res = tmp;
        }
        return res;
    }

    /**
     * 比较两个数组中较大者，nums1>nums2或相等返回true
     */
    private boolean compare(int[] nums1, int idx1, int[] nums2, int idx2) {
        while (idx1 < nums1.length && idx2 < nums2.length && nums1[idx1] == nums2[idx2]) {
            idx1++;
            idx2++;
        }
        return idx2 == nums2.length || (idx1 < nums1.length && nums1[idx1] > nums2[idx2]);
    }

    /**
     * 合并两个数组，组成当前数组的最大数
     */
    private int[] merge(int[] nums1, int[] nums2) {
        int idx1 = 0, idx2 = 0;
        int[] res = new int[nums1.length + nums2.length];
        int idx = 0;
        while (idx1 < nums1.length || idx2 < nums2.length) {
            if (compare(nums1, idx1, nums2, idx2)) {
                res[idx++] = nums1[idx1++];
            } else {
                res[idx++] = nums2[idx2++];
            }
        }
        return res;
    }

    /**
     * 获取当前数组取出k个数时的最大数
     */
    private int[] maxArr(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[k];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            while (len - i > k - idx && idx > 0 && nums[i] > res[idx - 1]) {
                idx--;
            }
            if (idx < k) {
                res[idx++] = nums[i];
            }
        }
        return res;
    }
}