package 未归类.q959_由斜杠划分区域.s2;

/**
 * 并查集
 * 把每一个网格分为2*2的小网格，上右下左分别为0、1、2、3，则并查集的parent数组为parent[4*len*len]，
 * 假设当前不为\时，则将0和3合并，1和2合并，并且合并周围4个网格（如果有的话），
 * 最后从并查集中找出parent[i]==i的，即区域加1。
 */
class Solution {
    public int regionsBySlashes(String[] grid) {
        int len = grid.length;
        UF uf = new UF(4 * len * len);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                char ch = grid[i].charAt(j);
                int root = 4 * (i * len + j);

                if (ch != '/') {
                    uf.union(root, root + 1);
                    uf.union(root + 2, root + 3);
                }
                if (ch != '\\') {
                    uf.union(root, root + 3);
                    uf.union(root + 1, root + 2);
                }

                if (i > 0) {
                    uf.union(root, root - 4 * len + 2);
                }
                if (i < len - 1) {
                    uf.union(root + 2, root + 4 * len);
                }
                if (j > 0) {
                    uf.union(root + 3, root - 4 + 1);
                }
                if (j < len - 1) {
                    uf.union(root + 1, root + 4 + 3);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 4 * len * len; i++) {
            if (uf.findParent(i) == i) {
                res++;
            }
        }
        return res;
    }

    class UF {
        private int[] parent;

        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findParent(int x) {
            if (parent[x] != x) {
                parent[x] = findParent(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = findParent(x);
            int py = findParent(y);
            parent[px] = py;
        }
    }
}
