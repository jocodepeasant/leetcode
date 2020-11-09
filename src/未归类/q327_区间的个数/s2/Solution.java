package 未归类.q327_区间的个数.s2;

/**
 * 前缀和+归并排序
 */
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long tmp = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            sum[i + 1] = tmp;
        }
        return helper(sum, lower, upper, 0, sum.length - 1);
    }

    private int helper(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int n1 = helper(sum, lower, upper, left, mid);
        int n2 = helper(sum, lower, upper, mid + 1, right);
        int ret = n1 + n2;

        int i = left;
        int l = mid + 1;
        int r = mid + 1;
        while (i <= mid) {
            while (l <= right && sum[l] - sum[i] < lower) {
                l++;
            }
            while (r <= right && sum[r] - sum[i] <= upper) {
                r++;
            }
            ret += r - l;
            i++;
        }

        long[] sorted = new long[right - left + 1];
        int p1 = left, p2 = mid + 1;
        int p = 0;
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid) {
                sorted[p++] = sum[p2++];
            } else if (p2 > right) {
                sorted[p++] = sum[p1++];
            } else {
                if (sum[p1] > sum[p2]) {
                    sorted[p++] = sum[p2++];
                } else {
                    sorted[p++] = sum[p1++];
                }
            }
        }
        for (int j = 0; j < sorted.length; j++) {
            sum[left++] = sorted[j];
        }
        return ret;
    }
}