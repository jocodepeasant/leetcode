package 未归类.q116_填充每个节点的下一个右侧节点指针.s1;

import 未归类.Node;

/**
 * 平时自练地
 */
class Solution {
    public Node connect(Node root) {
        //存储上一层节点
        Node pre = root;
        while (pre != null) {
            Node cur = new Node(0);
            Node node = cur;
            //遍历上一层节点
            while (pre != null) {
                if (pre.left != null) {
                    cur.next = pre.left;
                    cur = cur.next;
                }
                if (pre.right != null) {
                    cur.next = pre.right;
                    cur = cur.next;
                }
                pre = pre.next;
            }
            pre = node.next;
        }
        return root;
    }
}
