package 图.q684_冗余连接.s1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 使用map保存无向图的连接信息，对每个edges，类似于树的遍历进行遍历，直到：
 * a、没有下一个未遍历过的连接点，返回false
 * b、返回到开始节点，返回true
 * ps：题目要返回最后出现的边，故需要从后开始遍历edges。
 */
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //存储节点
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][0])) {
                map.put(edges[i][0], new ArrayList<>());
            }
            if (!map.containsKey(edges[i][1])) {
                map.put(edges[i][1], new ArrayList<>());
            }
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        //找到最后出现的边
        for (int i=edges.length-1;;i--){
            if (helper(edges[i][0],edges[i][1],map,edges[i][0],new HashSet<Integer>())){
                return edges[i];
            }
        }
    }

    private boolean helper(int u, int v, HashMap<Integer, List<Integer>> map, int target, HashSet<Integer> set) {
        if (target == v) {
            return true;
        }
        if (set.contains(v)){
            return false;
        }
        List<Integer> integers = map.get(v);
        set.add(u);
        if (integers != null) {
            for (int i : integers
            ) {
                if (i == u) continue;
                if (helper(v, i, map, target,set)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,3},{3,4},{1,5},{3,5},{2,3}};
        Solution solution = new Solution();
        int[] redundantConnection = solution.findRedundantConnection(edges);
        System.out.println(redundantConnection[0]+"   "+redundantConnection[1]);
    }
}
