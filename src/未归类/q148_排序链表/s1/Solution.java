package 未归类.q148_排序链表.s1;

import 未归类.q141_环形链表.ListNode;

/**
 * 快速排序，超时
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        quickSort(pre, null);
        return pre.next;
    }

    private void quickSort(ListNode begin, ListNode end) {
        if (begin.next == end) {
            return;
        }
        ListNode pre = begin;
        ListNode left = begin.next;
        ListNode mid = begin.next;
        while (left.next != end) {
            if (left.next.val < mid.val) {
                ListNode tmp = left.next.next;
                left.next.next = pre.next;
                pre = pre.next;
                left.next = tmp;
            } else {
                left = left.next;
            }
        }
        if (begin.next != mid) {
            quickSort(begin, mid);
        }
        if (mid.next != end) {
            quickSort(mid, end);
        }
    }
}