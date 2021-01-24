package 图.q399_除法求值.s1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 有向图+dfs
 * 由于题目中指出不会存在矛盾的结果，故图中每一个点到另一个点的路径最多只有一条
 */
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> map = new HashMap<>();
        int idx = 0;
        //找出所有不重复的字符，并设置其在其后创建的图中的下标
        for (int i = 0; i < equations.size(); i++) {
            if (!map.containsKey(equations.get(i).get(0))) {
                map.put(equations.get(i).get(0), idx++);
            }
            if (!map.containsKey(equations.get(i).get(1))) {
                map.put(equations.get(i).get(1), idx++);
            }
        }

        List<Pair>[] edges = new List[idx];
        //初始化
        for (int i = 0; i < idx; i++) {
            edges[i] = new ArrayList<>();
        }

        //构建图
        for (int i = 0; i < equations.size(); i++) {
            int x = map.get(equations.get(i).get(0));
            int y = map.get(equations.get(i).get(1));
            edges[x].add(new Pair(y, values[i]));
            edges[y].add(new Pair(x, 1.0 / values[i]));
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> list = queries.get(i);
            //初始化
            double tmp = -1.0;
            if (map.containsKey(list.get(0)) && map.containsKey(list.get(1))) {
                int x = map.get(list.get(0));
                int y = map.get(list.get(1));
                if (x == y) {
                    tmp = 1.0;
                } else {
                    LinkedList<Integer> points = new LinkedList<>();
                    points.offer(x);
                    double[] ratios = new double[idx];
                    ratios[x] = 1.0;
                    while (!points.isEmpty() && ratios[y] == 0) {
                        int t = points.poll();
                        for (Pair pair : edges[t]) {
                            int j = pair.idx;
                            double val = pair.value;
                            if (ratios[j] == 0) {
                                ratios[j] = ratios[t] * val;
                                points.offer(j);
                            }
                            //找到，结束循环
                            if (j == y) {
                                tmp = ratios[j];
                                break;
                            }
                        }
                    }
                }
            }
            res[i] = tmp;
        }
        return res;
    }

    class Pair {
        int idx;
        double value;

        public Pair(int idx, double value) {
            this.idx = idx;
            this.value = value;
        }
    }
}