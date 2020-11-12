/**
 * 快排思想
 */
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int left = 0;
        int right = 1;
        for (; left < A.length; left+=2) {
            if (A[left] % 2 == 1) {
                while (A[right] % 2 != 1) {
                    right+=2;
                }
                swap(A, left, right);
            }
        }
        return A;
    }

    private void swap(int[] A, int left, int right) {
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
    }
}