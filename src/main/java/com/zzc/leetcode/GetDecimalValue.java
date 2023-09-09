package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-23 12:23
 */
public class GetDecimalValue {
    public static void main(String[] args) {

    }
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }

        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
