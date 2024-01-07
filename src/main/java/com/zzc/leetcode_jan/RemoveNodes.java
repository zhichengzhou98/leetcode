package com.zzc.leetcode_jan;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-01-03 11:59
 */
public class RemoveNodes {
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = removeNodes(head.next);
        if (head.val < nextNode.val) {
            return nextNode;
        }
        head.next = nextNode;
        return head;
    }

    public ListNode removeNodes1(ListNode head) {
        //
        ListNode current = head;
        List<Integer> list = new ArrayList<>();
        while (current!=null) {
            list.add(current.val);
            current = current.next;
        }
        Stack<int[]> stack = new Stack<>();
        for (int i = list.size()-1; i >= 0; i--) {
            int currentNum = list.get(i);
            if (!stack.isEmpty()) {
                int max = stack.peek()[0];
                if (max <= currentNum) {
                    stack.push(new int[]{currentNum, i});
                }
            }else {
                stack.push(new int[]{currentNum, i});
            }
        }
        ListNode node = new ListNode();
        ListNode node1 = node;
        int index = 0;
        current = head;
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            while (pop[1] != index) {
                current = current.next;
                index++;
            }
            node1.next = current;
            node1 = node1.next;
        }
        return node.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode( int val){
        this.val = val;
    }
    ListNode( int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

