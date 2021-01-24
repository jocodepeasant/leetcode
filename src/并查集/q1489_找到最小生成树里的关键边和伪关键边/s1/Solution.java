package 并查集.q1489_找到最小生成树里的关键边和伪关键边.s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 并查集
 * 关建边：如果最小生成树中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。也就是说，如果设原图最小生成树的权值为 value，那么去掉这条边后：
 * a、要么整个图不连通，不存在最小生成树
 * b、要么重新生成的最小树值大于value
 *
 * 伪关建边：可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。也就是说，在除去关建边后，如果生成的最小树值和原来一样，那么就是伪关建边。
 * 故而我们需要先判断当前边是否是关建边，不是在判断是否是伪关建边
 *
 * 首先将各个边按权值从小到大排列，采用并查集，获得生成的最小生成树大小。
 */
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int len = edges.length;
        int[][] newEdges = new int[len][4];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }

        Arrays.sort(newEdges, Comparator.comparingInt(x -> x[2]));

        UnionFind unionFind = new UnionFind(n);
        //最小生成树
        int min = 0;
        for (int i = 0; i < len; i++) {
            if (unionFind.union(newEdges[i][0], newEdges[i][1])) {
                min += newEdges[i][2];
            }
        }

        ArrayList<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        for (int i = 0; i < len; i++) {
            //关建边判断
            unionFind = new UnionFind(n);
            int val = 0;
            for (int j = 0; j < len; j++) {
                if (i != j && unionFind.union(newEdges[j][0], newEdges[j][1])) {
                    val += newEdges[j][2];
                }
            }
            if (unionFind.getCut() > 1 || (unionFind.getCut() == 1 && val > min)) {
                res.get(0).add(newEdges[i][3]);
                continue;
            }

            //伪关建边判断
            unionFind = new UnionFind(n);
            unionFind.union(newEdges[i][0], newEdges[i][1]);
            val = newEdges[i][2];
            for (int j = 0; j < len; j++) {
                if (i != j && unionFind.union(newEdges[j][0], newEdges[j][1])) {
                    val += newEdges[j][2];
                }
            }
            if (val == min) {
                res.get(1).add(newEdges[i][3]);
            }
        }
        return res;
    }

    class UnionFind {
        private int[] parent;
        //连通数量
        private int cut;

        public UnionFind(int n) {
            parent = new int[n];
            cut = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            parent[rootX] = rootY;
            --cut;
            return true;
        }

        public int getCut() {
            return cut;
        }
    }
}

