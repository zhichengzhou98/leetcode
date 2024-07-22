package com.zzc.leetcode_jul;

import com.zzc.template.UnionFind;
import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;


/**
 * @author zc.zhou
 * @Description 2101. 引爆最多的炸弹 不能使用并查集。能被引爆必须是爆炸范围包含另一个爆炸点的圆心
 * a能引爆b, b不一定能引爆a, 因此不能使用并查集。--> 有向图
 * @create 2024-07-22 9:12
 */
public class MaximumDetonation {
  @Test
  void testFun() throws IOException {
    int[][] bombs  = ArrayUtils.generate("array", int[][].class);
    System.out.println(maximumDetonation(bombs));
  }

  public int maximumDetonation(int[][] bombs) {
    //建图
    //lists[i] 表示i炸弹能引爆的炸弹
    List[] lists = new List[bombs.length];
    for (int i = 0; i < lists.length; i++) {
      lists[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < bombs.length; i++) {
      for (int j = i + 1; j < bombs.length; j++) {
        if (isRelated1(bombs[i], bombs[j])) {
          lists[i].add(j);
        }
        if (isRelated1(bombs[j], bombs[i])) {
          lists[j].add(i);
        }
      }
    }
    int res = 1;
    //广度优先
    //遍历每个点
    for (int i = 0; i < bombs.length; i++) {
      boolean[] isVisited = new boolean[bombs.length];
      Queue<Integer> deque = new ArrayDeque<>();
      deque.offer(i);
      int temp = 0;
      //当前节点已经被遍历过
      isVisited[i] = true;
      while (!deque.isEmpty()) {
        Integer currentBomb = deque.poll();
        temp += 1;
        //获取能引爆的点
        List<Integer> next = lists[currentBomb];
        for (int nextBomb : next) {
          if (!isVisited[nextBomb]) {
            deque.offer(nextBomb);
            isVisited[nextBomb] = true;
          }
        }
      }
      res = Math.max(res, temp);
    }
    return res;
  }

  //判断bomb1是否能引爆bomb2
  private boolean isRelated1(int[] bomb1, int[] bomb2) {
    int x1 = bomb1[0];
    int y1 = bomb1[1];
    int r1 = bomb1[2];

    int x2 = bomb2[0];
    int y2 = bomb2[1];
    double res =Math.pow(r1, 2) - (Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    return res >= 0.0;
  }


  public int maximumDetonation1(int[][] bombs) {
    UnionFind uf = new UnionFind(bombs.length);
    for (int i = 0; i < bombs.length; i++) {
      for (int j = i + 1; j < bombs.length; j++) {
        if (isRelated(bombs[i], bombs[j])) {
          uf.union(i, j);
        }
      }
    }
    return Arrays.stream(uf.getCount()).max().orElse(1);
  }

  private boolean isRelated(int[] bomb1, int[] bomb2) {
    int x1 = bomb1[0];
    int y1 = bomb1[1];
    int r1 = bomb1[2];

    int x2 = bomb2[0];
    int y2 = bomb2[1];
    int r2 = bomb2[2];
    double res = Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2) - Math.pow((r2 + r1), 2);
    return res < 0.0;
  }
}
