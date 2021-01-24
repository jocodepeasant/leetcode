package 并查集.q1319_连通网络的操作次数.s1;

/**
 * 并查集
 * 要连通网络，首先需要确保网线够用，只要网线够用，就一定能够连通网络。
 * 使用并查集，把已经连通的标记出来，需要操作的次数即为连通量的数量-1。
 */
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        //网线不够
        if (len < n - 1) {
            return -1;
        }
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < len; i++) {
            unionFind.union(connections[i][0], connections[i][1]);
        }
        return unionFind.getCut() - 1;
    }

    //并查集模板
    class UnionFind {
        private int[] parent;
        //连通量
        private int cut;

        public UnionFind(int n) {
            cut = n;
            parent = new int[n];
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

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            cut--;
        }

        public int getCut() {
            return this.cut;
        }
    }
}