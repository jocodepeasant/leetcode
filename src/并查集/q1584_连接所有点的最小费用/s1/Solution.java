package 并查集.q1584_连接所有点的最小费用.s1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 并查集
 * 获取每两个点构成边的长度作为权值，将权值从小到大排列，采用并查集，遍历边，只要不构成闭环图就加入该值，所得结果即是最小费用。
 */
public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        DisjointSetUnion disjointSetUnion = new DisjointSetUnion(len);
        ArrayList<Edge> list = new ArrayList<>();
        //计算每条边的长度（权值）
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                list.add(new Edge(getDist(points, i, j), i, j));
            }
        }

        //排序
        Collections.sort(list, Comparator.comparingInt(Edge::getLen));

        int ret = 0, cut = 0;
        for (int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);
            int l = edge.getLen();
            int x = edge.getX();
            int y = edge.getY();
            //只要没构成闭环图，即满足题目两点之间只有一条路径
            if (disjointSetUnion.union(x, y)) {
                ret += l;
                cut++;
                if (cut == len) {
                    break;
                }
            }
        }
        return ret;
    }

    private int getDist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }

    /**
     * 并查集模板
     */
    class DisjointSetUnion {
        int[] f;
        int n;

        public DisjointSetUnion(int n) {
            this.n = n;
            this.f = new int[n];
            for (int i = 0; i < n; i++) {
                this.f[i] = i;
            }
        }

        public int find(int x) {
            if (f[x] != x) {
                f[x] = find(f[x]);
            }
            return f[x];
        }

        public boolean union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            //闭环
            if (fx == fy) {
                return false;
            }
            f[fx] = fy;
            return true;
        }
    }

    class Edge {
        private int len, x, y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }

        public int getLen() {
            return len;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
