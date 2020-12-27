package 未归类.q141_环形链表.s1;

import 未归类.q141_环形链表.ListNode;

import java.util.HashSet;

/**
 * 哈希表存储
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
