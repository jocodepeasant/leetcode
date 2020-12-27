package 贪心算法.q5638_吃苹果的最大数目.s1;

/**
 * 贪心：
 * 优先吃快过期的苹果，时间复杂度O(N*N)
 */
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int day = 0;
        //找出苹果还未全部腐烂的最后日期
        for (int i = 0; i < days.length; i++) {
            day = Math.max(i + days[i], day);
        }
        //下标值表示失效日期，存储在当天后即腐烂的苹果数
        int[] tmp = new int[day];
        int res = 0;
        for (int i = 0; i < day; i++) {
            //保存当天新长出的苹果
            if (i < apples.length && apples[i] != 0) {
                tmp[i + days[i] - 1] += apples[i];
            }
            int idx = i;
            //取出最先腐烂的苹果
            while (idx < day && tmp[idx] == 0) {
                idx++;
            }
            //没有可取出的苹果
            if (idx == day) {
                continue;
            } else {
                tmp[idx]--;
                res++;
            }
        }
        return res;
    }
}