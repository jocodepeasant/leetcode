package 排序.q1365_有多少小于当前数字的数字;

/**
 * 计数排序：
 * 第一次遍历使用一个数组保存当前数字的个数，第二次遍历累加，计算直到目前出现的数字个数，设当前值为i，则小于i的个数为cut[i-1];
 * @author fzb
 * @date 2020/10/26 13:02
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cut = new int[102];
        //计数
        for (int n :
                nums) {
            cut[n + 1]++;
        }
        //计算直到目前的个数
        for (int i = 1; i < 102; i++) {
            cut[i] += cut[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = cut[nums[i]];
        }
        return nums;
    }
}
