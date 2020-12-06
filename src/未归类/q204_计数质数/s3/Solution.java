package 未归类.q204_计数质数.s3;

/**
 * 埃氏筛，每次取出一个质数后将筛出后面的非质数
 */
class Solution {
    public int countPrimes(int n) {
        boolean[] tmp = new boolean[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!tmp[i]) {
                res++;
            }
            if ((long) i * i < n) {
                //i*i之前的非质数均已被遍历
                for (int j = i * i; j < n; j += i) {
                    tmp[j] = true;
                }
            }
        }
        return res;
    }
}