package com.topic.baoli;

import com.topic.dfs.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zc.zhou
 * @Description 23合并K个升序链表
 *  k == lists.length
 *  0 <= k <= 10^4
 *  0 <= lists[i].length <= 500
 *  -10^4 <= lists[i][j] <= 10^4
 *  lists[i] 按 升序 排列
 *  lists[i].length 的总和不超过 10^4
 * @create 2024-09-23 15:20
 */
public class MergeKLists {
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode head = new ListNode(Integer.MAX_VALUE);
    ListNode tmp = head;
    //0表示值 1表示在listnode[]数组中的index
    PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.node.val));
    for (int i = 0; i < lists.length; i++) {
      ListNode list = lists[i];
      if (list != null) {
        pq.offer(new Pair(list, i));
        lists[i] = list.next;
      }
    }
    while (!pq.isEmpty()) {
      Pair poll = pq.poll();
      tmp.next = poll.node;
      //从lists[i]中再加一个节点到队列
      ListNode list = lists[poll.index];
      if (list != null) {
        pq.offer(new Pair(list, poll.index));
        lists[poll.index] = list.next;
      }
      tmp = tmp.next;
    }
    return head.next;
  }
}
class Pair {
  ListNode node;
  int index;

  public Pair(ListNode node, int index) {
    this.node = node;
    this.index = index;
  }
}
