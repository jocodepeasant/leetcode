package 未归类.q148_排序链表.s3;

import 未归类.q141_环形链表.ListNode;

/**
 * 归并排序，自底向上，时间复杂度O（nlogn)（执行时间较s2长)，空间复杂度O(1)
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode res = new ListNode(0);
        res.next = head;
        while (head != null) {
            head = head.next;
            len++;
        }
        for (int i = 1; i < len; i <<= 1) {
            ListNode pre = res, cur = pre.next;
            while (cur != null) {
                ListNode listNode1 = cur, listNode2;
                for (int j = 1; j < i && cur.next != null; j++) {
                    cur = cur.next;
                }
                listNode2 = cur.next;
                cur.next = null;
                cur = listNode2;
                for (int j = 1; j < i && cur != null && cur.next != null; j++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                ListNode merge = mergeSort(listNode1, listNode2);
                pre.next = merge;
                while (pre.next != null) {
                    pre = pre.next;
                }
                cur = next;
            }
        }
        return res.next;
    }

    private ListNode mergeSort(ListNode head1, ListNode head2) {
        ListNode res = new ListNode(0);
        ListNode pre = res;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                pre.next = head1;
                head1 = head1.next;
            } else {
                pre.next = head2;
                head2 = head2.next;
            }
            pre = pre.next;
        }
        if (head1 != null) {
            pre.next = head1;
        } else {
            pre.next = head2;
        }
        return res.next;
    }
}