package com.topic.baoli;

import com.zzc.utils.ArrayUtils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zc.zhou
 * @Description 2343
 * @create 2024-08-27 17:17
 */
public class SmallestTrimmedNumbers {
  @Test
  void testFun() throws IOException {
    String[] nums = {"102","473","251","814"};
    int[][] q = ArrayUtils.generate("array", int[][].class);
    System.out.println(Arrays.toString(smallestTrimmedNumbers(nums, q)));
  }
  public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
    int[] res = new int[queries.length];
    //q * (n + n * m * logn)
    for (int i = 0; i < queries.length; i++) {
      int[] q = queries[i];
      int k = q[0];
      int lastStr = q[1];
      String[][] arr = new String[nums.length][2];
      for (int j = 0; j < nums.length; j++) {
        int len = nums[j].length();
        arr[j][0] = nums[j].substring(len - lastStr).trim();
        arr[j][1] = String.valueOf(j);
      }
      res[i] = minK(arr, k);
    }
    return res;
  }

  private int minK(String[][] nums, int k) {
    //找到第k小的数
    // 0 =< k <= num.length
    Arrays.sort(nums, Comparator.comparing(a -> a[0]));
    return Integer.parseInt(nums[k - 1][1]);
  }
}
