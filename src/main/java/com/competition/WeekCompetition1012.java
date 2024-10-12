package com.competition;

import com.topic.template.IsPrime;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-10-12 22:25
 */
public class WeekCompetition1012 {
  @Test
  void testFun() {
    List<Integer> list = IsPrime.sieveOfEratosthenes(100);
    int[] res = minBitwiseArray(list);
    int[][] arr = new int[res.length][2];
    for (int i = 0; i < arr.length; i++) {
      arr[i][0] = res[i];
      arr[i][1] = list.get(i);
    }
    System.out.println(Arrays.deepToString(arr));
    System.out.println(Integer.toBinaryString(23));
  }

  public int[] minBitwiseArrayV1(List<Integer> nums) {
    int n = nums.size();
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      int target = nums.get(i);
      res[i] = -1;
      for (int j = 0; j <= target; j++) {
        if ((j | (j + 1)) == target) {
          res[i] = j;

          break;
        }
      }
    }
    return res;
  }

  public int[] minBitwiseArray(List<Integer> nums) {
    int n = nums.size();
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      int target = nums.get(i);
      if (target == 2) {
        res[i] = -1;
        continue;
      }
      String s = Integer.toBinaryString(target);
      char[] chars = s.toCharArray();
      int r = chars.length - 1;
      while (r >=0 && chars[r] == '1') {
        r--;
      }
      if (r == 0) {
        chars[r] = '0';
      } else {
        chars[r + 1] = '0';
      }
      String s1 = new String(chars);
      res[i] = Integer.parseInt(s1, 2);
    }
    return res;
  }
}
