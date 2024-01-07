package com.zzc.leetcode_jan;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-01-06 20:09
 */
public class InsertGreatestCommonDivisors {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int maxCommonDivisors = maxCommonDivisors(head.val, head.next.val);
        ListNode listNode = new ListNode(maxCommonDivisors);
        listNode.next = insertGreatestCommonDivisors(head.next);
        head.next = listNode;
        return head;
    }
    public int maxCommonDivisors(int a, int b) {
        int dividend = Math.max(a, b);
        int divisor = Math.min(a, b);
        //余数 remainder
        int remainder = dividend % divisor;
        if (remainder == 0) {
            return divisor;
        }
        return maxCommonDivisors(divisor, remainder);
    }

    public int maxCommonDivisors1(int a, int b) {
        int maxRes = Math.min(a, b);
        for (int i = maxRes; i >=  1 ; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
