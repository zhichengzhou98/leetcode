package com.topic.pq;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zc.zhou
 * @Description 295. 数据流的中位数 优先队列
 * @create 2024-09-24 19:30
 */
public class MedianFinder {
  @Test
  void testFun() {
    MedianFinder mf = new MedianFinder();
    mf.addNum(-1);
    mf.addNum(-2);
    mf.addNum(-3);
    System.out.println(mf.findMedian());
  }

  //大顶堆，保存数据前半部分的数
  Queue<Integer> bigQ;

  //小顶堆，保存数据后半部分的数
  Queue<Integer> smallQ;

  int n;

  public MedianFinder() {
    bigQ = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
    smallQ = new PriorityQueue<>();
  }

  public void addNum(int num) {
    if (smallQ.size() > bigQ.size()) {
      //数据后半部分 比 前半部分多1个 => 新数据应该插入到前半部分
      if (num >= smallQ.peek()) {
        bigQ.offer(smallQ.poll());
        smallQ.offer(num);
      } else {
        bigQ.offer(num);
      }
    } else if (bigQ.size() > smallQ.size()) {
      //数据前半部分 比 前半部分多1个 => 新数据应该插入到后半部分
      if (num <= bigQ.peek()) {
        smallQ.offer(bigQ.poll());
        bigQ.offer(num);
      } else {
        smallQ.offer(num);
      }
    } else {
      if (!smallQ.isEmpty() && num <= smallQ.peek()) {
        bigQ.offer(num);
      } else {
        smallQ.offer(num);
      }
    }
    n++;
  }


  public double findMedian() {
    if (smallQ.size() > bigQ.size()) {
      return smallQ.peek();
    } else if (smallQ.size() < bigQ.size()) {
      return bigQ.peek();
    } else {
      if (!bigQ.isEmpty()) {
        return (bigQ.peek() + smallQ.peek()) / 2.0;
      }
      return 0;
    }

  }
}

