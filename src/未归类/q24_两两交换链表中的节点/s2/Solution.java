package 未归类.q24_两两交换链表中的节点.s2;

import 未归类.q141_环形链表.ListNode;

/**
 * 递归
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
