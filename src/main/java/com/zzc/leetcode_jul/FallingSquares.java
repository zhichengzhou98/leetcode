package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 699 线段树
 * @create 2024-07-28 08:43
 */
public class FallingSquares {
  @Test
  void testFun() {
    int[][] positions = {{1,1}, {2,1}};
    System.out.println(fallingSquares(positions));
  }
  //内存溢出
  public List<Integer> fallingSquares(int[][] positions) {
    //一次循环 查分数组
    //res表示第i个方块降落时的高度
    int[] res = new int[positions.length];
    // 统计差分数组的len
    int maxLength = Integer.MIN_VALUE;
    for(int[] pos : positions) {
      maxLength = Math.max(maxLength, pos[0] + pos[1]);
    }
    //差分数组
    int[] diff = new int[maxLength + 2];
    for (int i = 0; i < positions.length; i++) {
      //当前方块
      int[] currentSquare = positions[i];
      //当前高度
      int height = currentSquare[1];
      //当前区间
      int[] b = new int[]{currentSquare[0], currentSquare[0] + height};
      //把当前区间 所有位置 的最大高度再加height
      //差分数组diff表示了每个点的最大高度
      //找到区间b最大高度
      //求最大高度也需要判断擦边的情况
      int maxHeightB = 0;
      if (diff[b[0]+ 1]  != 0) {
        maxHeightB = diff[b[0]];
      }
      for (int j = b[0] + 1; j <= b[1]; j++) {
        maxHeightB = Math.max(maxHeightB, diff[j]);
      }
      //把区间b最大高度都更新为maxHeightB + height
      //判断刚好擦边的情况
      if (diff[b[0] + 1]  != 0) {
        diff[b[0]] = maxHeightB + height;
      }
      for (int j = b[0] + 1; j <= b[1]; j++) {
        diff[j] = maxHeightB + height;
      }
      res[i] = maxHeightB + height;
    }
    for (int i = 1; i < res.length; i++) {
      res[i] = Math.max(res[i], res[i - 1]);
    }
    return Arrays.stream(res).boxed().toList();
  }
  public List<Integer> fallingSquaresV1(int[][] positions) {
    //双重循环
    //res表示第i个方块降落时的高度
    int[] res = new int[positions.length];
    //第一个方块降落的最大高度就是方块的边长
    res[0] = positions[0][1];
    for (int i = 1; i < positions.length; i++) {
      //当前方块
      int[] currentSquare = positions[i];
      //当前高度
      int height = currentSquare[1];
      //当前区间
      int[] b = new int[]{currentSquare[0], currentSquare[0] + height};
      //当前高度至少为height
      res[i] = height;
      for (int j = 0; j < i; j++) {
        //之前方块
        int[] preSquare = positions[j];
        //判断与之前区间的交集
        int[] a = new int[]{preSquare[0], preSquare[0] + preSquare[1]};
        //如果和之前的区间有交集
        if (isUnionZone(a, b)) {
          res[i] = Math.max(res[i], res[j] + height);
        }
      }
    }
    for (int i = 1; i < res.length; i++) {
      res[i] = Math.max(res[i], res[i - 1]);
    }
    return Arrays.stream(res).boxed().toList();
  }

  //判断两个区间是否有交集
  public boolean isUnionZone(int[] a, int[] b) {
    if (b[1] <= a[0] || b[0] >= a[1]) {
      return false;
    }
    return true;
  }
}
