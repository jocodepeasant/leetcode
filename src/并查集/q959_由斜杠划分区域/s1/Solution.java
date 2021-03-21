package 并查集.q959_由斜杠划分区域.s1;

/**
 * 并查集
 */
class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind unionFind = new UnionFind(4 * n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                if (i > 0) {
                    unionFind.union(4 * idx, 4 * (idx - n) + 2);
                }
                if (j > 0) {
                    unionFind.union(4 * idx + 3, 4 * (idx - 1) + 1);
                }
                if (grid[i].charAt(j) == '\\') {
                    unionFind.union(4 * idx, 4 * idx + 1);
                    unionFind.union(4 * idx + 2, 4 * idx + 3);
                } else if (grid[i].charAt(j) == '/') {
                    unionFind.union(4 * idx, 4 * idx + 3);
                    unionFind.union(4 * idx + 1, 4 * idx + 2);
                } else {
                    unionFind.union(4 * idx, 4 * idx + 1);
                    unionFind.union(4 * idx + 1, 4 * idx + 2);
                    unionFind.union(4 * idx + 2, 4 * idx + 3);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 4 * n * n; i++) {
            if (unionFind.find(i) == i) {
                res++;
            }
        }
        return res;
    }

    class UnionFind {
        private int[] parent;

        public UnionFind(int k) {
            this.parent = new int[k];
            for (int i = 0; i < k; i++) {
                this.parent[i] = i;
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
        }
    }
}