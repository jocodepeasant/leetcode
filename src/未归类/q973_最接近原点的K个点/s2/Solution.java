package 未归类.q973_最接近原点的K个点.s2;

import java.util.Arrays;

/**
 * 快排思想
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        quickSort(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void quickSort(int[][] points, int begin, int end, int K) {
        int left = begin, right = end;
        int[] tmp = points[begin];
        int leftVal = tmp[0] * tmp[0] + tmp[1] * tmp[1];
        while (left < right) {
            while (left < right && points[right][0] * points[right][0] + points[right][1] * points[right][1] >= leftVal) {
                right--;
            }
            if (left < right) {
                points[left++] = points[right];
            }
            while (left < right && points[left][0] * points[left][0] + points[left][1] * points[left][1] < leftVal) {
                left++;
            }
            if (left < right) {
                points[right--] = points[left];
            }
        }
        points[left] = tmp;
        //当前K个最小数选出来时不再排序
        if (left > K - 1) {
            //最小数必定都在左边
            quickSort(points, begin, left - 1, K);
        } else if (left < K - 1) {
            //已选出left+1个最小数，从右边再选出剩下的最小数
            quickSort(points, left + 1, end, K);
        }
    }
}