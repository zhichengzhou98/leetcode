package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-29 07:24
 */
public class TimeRequiredToBuy {
  public int timeRequiredToBuy(int[] tickets, int k) {
    int res = 0;
    for (int i = 0; i < tickets.length; i++) {
      if (i <= k) {
        res += Math.min(tickets[k], tickets[i]);
      } else {
        res += Math.min(tickets[k] - 1, tickets[i]);
      }
    }
    return res;
  }
}
