package 未归类.q941_有效的山脉数组.s1;

/**
 * 回溯：
 * 在当前数组中进行元素交换，不需要额外空间。
 */
class Solution {
    public boolean validMountainArray(int[] A) {
        int idx = 0;
        for (; idx < A.length-1; idx++) {
            if (A[idx+1] <= A[idx]) {
                break;
            }
        }
        if (idx == 0 || idx == A.length - 1) {
            return false;
        }

        for (; idx < A.length - 1; idx++) {
            if (A[idx+1] >= A[idx]) {
                return false;
            }
        }
        return true;
    }
}
