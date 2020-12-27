package 未归类.q24_两两交换链表中的节点.s1;

import 未归类.q141_环形链表.ListNode;

/**
 * 迭代
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode pre = res;
        res.next = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            pre.next = cur.next;
            cur.next = pre.next.next;
            pre.next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return res.next;
    }
}
