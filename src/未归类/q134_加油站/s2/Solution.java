package 未归类.q134_加油站.s2;

/**
 * 贪心
 * 做一张x，y坐标图，起点为（0,0），pre=0，（i+1，pre+=gas[i]+cost[i]）为每一个点，画一张折线图，有以下结论：
 * ps：min表示最低点，minNe表示最低点后的一个点。
 * a：首先一个大前提，如果题目有解，该答案即为唯一答案，那么必然有最低点min且min小于0（排除只有一个的情况），且在min前方的点必然都到不了终点，
 * 因为无论怎么样在到达min前汽油都会耗尽，（可以想象将折线上移），sum[0-min]<0；
 * b：如果累加完剩余油量大于等于0，那么必然有解。
 * b：能够到达终点的起点必然为min后的第一个点minNe，为何？因为gas[minNe]+cost[minNe]必然为正数（否则最低点就不是前一个），
 * 在存在答案的情况下有：sum[0-min]+sum[minNe]+sum[minNe+1-end]>=0，如果起点在后面，
 * 那么sum[0-min]+sum[minNe+1-end]>=0，这样的话minNe和后面的某个点均能作为起点，与题意不符。
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int minVal = Integer.MAX_VALUE;
        int curVal = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            curVal += gas[i] - cost[i];
            if (curVal < minVal) {
                minVal = curVal;
                res = i;
            }
        }
        return curVal < 0 ? -1 : (res + 1) % gas.length;
    }
}