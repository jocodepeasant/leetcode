package 未归类.q116_填充每个节点的下一个右侧节点指针.s2;

import 未归类.Node;

/**
 * 平时自练地
 */
class Solution {
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node cur, Node next) {
        if (cur == null) {
            return;
        }
        cur.next = next;
        dfs(cur.left, cur.right);
        dfs(cur.right, next == null ? null : next.left);
    }
}
