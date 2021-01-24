package 图.q684_冗余连接.s2;

/**
 * 并查集，在遍历edges的过程中构造并查集，如果当前边两个点在并查集中的parent相同，
 * 表明当这个边加入后会构成有环图，即当前边为构成有环图的最后一条边，返回这条需要删除的边。
 */
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            //parent相同，返回这条边，否则，继续构造并查集
            if (unionFind.find(edges[i][0]) != unionFind.find(edges[i][1])) {
                unionFind.union(edges[i][0], edges[i][1]);
            } else {
                return edges[i];
            }
        }
        return null;
    }

    class UnionFind {
        private int[] parent;

        public UnionFind(int k) {
            parent = new int[k+1];
            for (int i = 1; i <= k; i++) {
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
            parent[rootX] = rootY;
        }
    }
}
