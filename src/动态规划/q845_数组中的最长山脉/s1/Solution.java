package 动态规划.q845_数组中的最长山脉.s1;

/**
 * 贪心算法：
 * 一个山脉必须由严格递增的左半部分和严格递减的右边部分组成，那么，设当前下标为i，A[i+1]>A[i]，则可能存在山脉，不然构不成山脉，
 * 当可能存在山脉时，一直遍历，直到开始递减的下标，如果找到则表明构成山脉，算出山脉长度，否则不构成山脉。
 * 需要知道的是当确定不构成山脉后，i前面的一定就不存在山脉了。
 * @author fzb
 * @date 2020/10/26 13:15
 */
class Solution {
    public int longestMountain(int[] A) {
        if(A.length<3){
            return 0;
        }
        int cur=0;
        int res=0;
        while(cur<A.length){
            int mid=cur;
            while(mid<A.length-1 && A[mid+1]>A[mid]){
                mid++;
            }
            if(mid==cur){
                cur++;
                continue;
            }
            int right=mid;
            while(right<A.length-1 && A[right+1]<A[right]){
                right++;
            }
            if(right==mid){
                cur=mid+1;
                continue;
            }
            res=Math.max(res,right-cur+1);
            cur=right;
        }
        return res;
    }
}
