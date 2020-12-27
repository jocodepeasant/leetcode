package 贪心算法.q31_下一个排列.s1;

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        break;
                    }
                }
                break;
            }
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        int mid = (begin + end + 1) / 2;
        while (begin < end) {
            int tmp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = tmp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nextPermutation(new int[]{1,3,2});
    }

}