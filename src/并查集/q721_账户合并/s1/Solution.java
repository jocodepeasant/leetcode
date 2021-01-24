package 并查集.q721_账户合并.s1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 并查集
 */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> emailToIndex = new HashMap<>();
        HashMap<String, String> emailToName = new HashMap<>();
        int count = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                if (!emailToIndex.containsKey(account.get(i))) {
                    //每个邮箱分配一个下标，保证唯一
                    emailToIndex.put(account.get(i), count++);
                    emailToName.put(account.get(i), name);
                }
            }
        }

        UnionFind unionFind = new UnionFind(count);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            for (int i = 2; i < account.size(); i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                unionFind.union(firstIndex, nextIndex);
            }
        }

        HashMap<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int index = unionFind.find(emailToIndex.get(email));
            indexToEmails.computeIfAbsent(index, x -> new ArrayList<>()).add(email);
        }

        ArrayList<List<String>> res = new ArrayList<>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String email = emails.get(0);
            String name = emailToName.get(email);
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(name);
            tmp.addAll(emails);
            res.add(tmp);
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
            parent[rootX] = rootY;
        }
    }
}