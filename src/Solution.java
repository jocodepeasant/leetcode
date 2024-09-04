//给你一个下标从 0 开始、长度为 n 的整数数组 nums ，其中 n 是班级中学生的总数。班主任希望能够在让所有学生保持开心的情况下选出一组学生：
//
// 如果能够满足下述两个条件之一，则认为第 i 位学生将会保持开心：
//
//
// 这位学生被选中，并且被选中的学生人数 严格大于 nums[i] 。
// 这位学生没有被选中，并且被选中的学生人数 严格小于 nums[i] 。
//
//
// 返回能够满足让所有学生保持开心的分组方法的数目。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1]
//输出：2
//解释：
//有两种可行的方法：
//班主任没有选中学生。
//班主任选中所有学生形成一组。
//如果班主任仅选中一个学生来完成分组，那么两个学生都无法保持开心。因此，仅存在两种可行的方法。
//
//
// 示例 2：
//
//
//输入：nums = [6,0,3,3,6,7,2,7]
//输出：3
//解释：
//存在三种可行的方法：
//班主任选中下标为 1 的学生形成一组。
//班主任选中下标为 1、2、3、6 的学生形成一组。
//班主任选中所有学生形成一组。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 0 <= nums[i] < nums.length
//
//
// Related Topics 数组 枚举 排序 👍 66 👎 0


import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int res = 0;
        for (int i = 0; i <= nums.size(); i++) {
            if (i > 0 && nums.get(i - 1) >= i) {
                continue;
            }
            if (i < nums.size() && nums.get(i) <= i) {
                continue;
            }
            res++;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)