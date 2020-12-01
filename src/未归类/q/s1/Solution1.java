package 未归类.q.s1;

import 未归类.q141_环形链表.ListNode;

/**
 * 平时自练地
 */
class Solution1 {
    public void reorderList(ListNode head) {
        ListNode left = new ListNode(0);
        ListNode right = left;
        left.next = head;
        int cut = 0;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
            cut++;
        }
        if (right == null) {
            cut--;
        }
        ListNode[] stack = new ListNode[cut];
        cut = 0;
        right = left.next;
        left.next = null;
        while (right != null) {
            stack[cut++] = right;
            right = right.next;
        }
        left = head;
        cut--;
        for (; cut >= 0; cut--) {
            stack[cut].next = left.next;
            left.next = stack[cut];
            left = stack[cut].next;
        }
    }
}
