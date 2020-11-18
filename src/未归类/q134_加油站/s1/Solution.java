package 未归类.q134_加油站.s1;

/**
 * 遍历
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (helper(gas, i, 0, cost, gas.length)) {
                return i;
            }
        }
        return -1;
    }

    private boolean helper(int[] gas, int idx, int i, int[] cost, int length) {
        if (length == 0) {
            return true;
        }
        int next = idx + 1 == gas.length ? 0 : idx + 1;
        i = i + gas[idx] - cost[idx];
        if (i < 0) {
            return false;
        }
        return helper(gas, next, i, cost, length - 1);
    }
}