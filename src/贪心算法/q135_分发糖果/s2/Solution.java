package 贪心算法.q135_分发糖果.s2;

/**
 * 贪心：
 * 孩子数组中不好确定的是评分为极大值（顶点）的孩子节点，其获取的糖果数需要联合其左右两边的值来确定，
 * 从左往右遍历，以升到极大值再降到极小值为一次循环，计算除极大值外的递增数和递减数，
 * 左右两边孩子获取的糖果数=(1+leftCut)*leftCut/2+(1+rightCut)*rightCut/2；极大值节点孩子获得的糖果数=max(leftCut,rightCut)+1,
 * 需要注意的是，当当前孩子等于前一个孩子评分时，当前孩子获得一个糖果。
 * （ps：无论左右，孩子获取糖果数从1到n和从n到1是一样的，默认右边从1到n，更容易理解本题解）
 */
class Solution {
    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int res = 0;
        int idx = 0;
        while (idx < ratings.length - 1) {
            int left = 0;
            //计算左孩子数（递增数）
            while (idx < ratings.length - 1 && ratings[idx] < ratings[idx + 1]) {
                left++;
                idx++;
            }
            int right = 0;
            //计算右孩子数（递减数）
            while (idx < ratings.length - 1 && ratings[idx] > ratings[idx + 1]) {
                right++;
                idx++;
            }
            //在第一轮过后，每一次都会重复计算第一个孩子获取的糖果数，即重复加1，需要减去
            if (res != 0) {
                res--;
            }
            //左边获取苹果数+右边获取苹果数+极大值（顶点）孩子获取的苹果数
            res += (1 + left) * left / 2 + (1 + right) * right / 2 + Math.max(left, right) + 1;
            //当前值=前面值，结果加1
            while (idx < ratings.length - 1 && ratings[idx] == ratings[idx + 1]) {
                idx++;
                res++;
            }
        }
        return res;
    }
}