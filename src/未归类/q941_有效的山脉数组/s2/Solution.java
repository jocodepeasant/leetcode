package 未归类.q941_有效的山脉数组.s2;

/**
 * 回溯：
 * 在当前数组中进行元素交换，不需要额外空间。
 */
class Solution {
    public boolean validMountainArray(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < A.length - 1 && A[left] < A[left+1]) {
            left++;
        }
        while (right > 0 && A[right] < A[right - 1]) {
            right--;
        }
        return left > 0 && right < A.length - 1 && left == right;
    }
}
