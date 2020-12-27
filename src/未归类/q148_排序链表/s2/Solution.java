package 未归类.q148_排序链表.s2;

import 未归类.q141_环形链表.ListNode;

import java.util.ArrayList;

/**
 * 归并排序，自顶向下，间复杂度O(nlogn)，空间复杂度O(n)，空间复杂度主要取决于递归调用的栈空间
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ArrayList<ListNode> tmp = new ArrayList<>();
        ListNode listNode = new ListNode(Integer.MIN_VALUE);
        tmp.add(listNode);
        ListNode cur = head;
        while (cur.next != null) {
            int left = 0, right = tmp.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (tmp.get(mid).val > cur.next.val) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ListNode listNode1 = tmp.get(left);
            ListNode next = cur.next;
            cur.next = cur.next.next;
            next.next = listNode1.next;
            listNode1.next = cur;
        }
        return new ListNode(0);
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head, null);
    }

    private ListNode mergeSort(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode listNode1 = mergeSort(head, slow);
        ListNode listNode2 = mergeSort(slow, tail);
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                cur.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                cur.next = listNode2;
                listNode2 = listNode2.next;
            }
            cur = cur.next;
        }
        if (listNode1 != null) {
            cur.next = listNode1;
        } else {
            cur.next = listNode2;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(4);
        ListNode node1 = node;
        node1.next = new ListNode(2);
        node1 = node1.next;
        node1.next = new ListNode(1);
        node1 = node1.next;
        node1.next = new ListNode(3);
        node1 = node1.next;
        ListNode listNode = solution.sortList(node);
        while (listNode != null) {
            System.out.printf(String.valueOf(listNode.val));
            listNode = listNode.next;
        }
    }
}