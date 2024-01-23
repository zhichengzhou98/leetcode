package com.zzc.leetcode_jan;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-01-14 21:04
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            }else {
                current = current.next;
            }

        }
        return head;
    }
}
