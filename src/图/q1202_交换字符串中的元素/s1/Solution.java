package 图.q1202_交换字符串中的元素.s1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 并查集
 * pairs中的索引可以看成边的两个点，所有的pairs连起来构成多个图，每个图中的点都可以随意交换，那么，
 * 当我们从左往右遍历s时，如果点属于某个图，我们总会将图中的最小值点拿出，交换当前的点，这样就能构成字典序最小的字符串了。
 */
public class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        //构建并查集
        for (int i = 0; i < pairs.size(); i++) {
            unionFind.union(pairs.get(i).get(0), pairs.get(i).get(1));
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            //同属一个图的点保存到一起，并且进行排序
            map.computeIfAbsent(unionFind.find(i), x -> new PriorityQueue<>()).offer(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            int tmp = unionFind.find(i);
            //取出最小值点
            sb.append(map.get(tmp).poll());
        }
        return sb.toString();
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int k) {
            parent = new int[k];
            rank = new int[k];
            for (int i = 0; i < k; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            //比较rank值，保证parent树不会太高
            if (rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootX]++;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
            }
        }
    }
}