package 图.q684_冗余连接.s2;

/**
 * 并查集
 */
public class Solution {
    int[] res = new int[2];

    public int[] findRedundantConnection(int[][] edges) {
        int[] father = new int[edges.length + 1];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
        for (int[] edge : edges
        ) {
            if (union(father, edge[0], edge[1])) {
                return res;
            }
        }
        return res;
    }

    private int findFather(int[] father, int x) {
        while (father[x] != x) {
            father[x] = father[father[x]];
            x = father[x];
        }
        return x;
    }

    private boolean union(int[] father, int u, int v) {
        int uFather = findFather(father, u);
        int vFather = findFather(father, v);
        if (uFather != vFather) {
            father[uFather] = vFather;
            return false;
        } else {
            res[0] = u;
            res[1] = v;
            return true;
        }
    }
}
