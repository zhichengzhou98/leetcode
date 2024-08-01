package com.zzc.leetcode_jul;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-01 11:04
 */
public class MaxmiumScore {
  @Test
  void testFun() {
    int[] cards = new int[]{1,2,8,9};
    System.out.println(maxmiumScore(cards, 3));
  }
  public int maxmiumScore(int[] cards, int cnt) {
    if (cnt > cards.length) {
      return 0;
    }
    Arrays.sort(cards);
    //降序排列
    int left = 0;
    int right = cards.length - 1;
    while (right > left) {
      int temp = cards[left];
      cards[left] = cards[right];
      cards[right] = temp;
      left++;
      right--;
    }
    //记录分数
    int res = 0;
    //记录最进的奇数和偶数
    int nearOdd = 0;
    int nearEven = 0;
    for (int i = 0; i < cnt; i++) {
      res += cards[i];
      if (cards[i] % 2 == 0) {
        nearEven = cards[i];
      } else {
        nearOdd = cards[i];
      }
    }
    if (res % 2 == 0) {
      return res;
    }
    //当前分数不为偶数
    //放弃最小的奇数 找下一个偶数
    int temp = res;
    if (nearOdd == 0) {
      //没有奇数可以放弃，不满足条件
      temp = 0;
    } else {
      temp -= nearOdd;
      //找下一个偶数
      left = cnt;
      while (left < cards.length && cards[left] % 2 == 1) {
        left++;
      }
      if (left >= cards.length) {
        //没找到下一个偶数
        temp = 0;
      } else {
        temp += cards[left];
      }

    }
    //放弃最小的偶数 找下一个奇数
    if (nearEven == 0) {
      //没有偶数可以放弃，不满足条件
      res = 0;
    } else {
      res -= nearEven;
      //找下一个奇数
      left = cnt;
      while (left < cards.length && cards[left] % 2 == 0) {
        left++;
      }
      if (left >= cards.length) {
        //没找到下一个偶数
        res = 0;
      } else {
        res += cards[left];
      }
    }
    return Math.max(res, temp);
  }
}
