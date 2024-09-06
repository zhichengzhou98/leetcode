package com.topic.dp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-09-06 10:17
 */
public class MaximumLength {
  @Test
  void testFun() {
    int[] arr = {465,209,998,359,889,333,515,762,939,593,419,824,87,246,922,199,152,429,241,143,400,111,126,384,216,199,482,159,272,480,830,155,680,298,861,229,358,250,719,296,811,930,71,139,397,913,33,847,645,537,379,81,506,97,308,512,417,192,172,880,931,268,78,294,82,320,223,367,622,143,360,861,451,453,510,762,365,163,585,872,275,215,34,535,988,855,899,490,570,24,331,77,276,271,296,785,1,583,158,90,191,278,733,125,501,661,381,967,234,375,265,141,555,378,165,688,684,118,802,228,531,90,470,248,51,560,837,956,911,486,107,408,240,548,622,420,694,109,287,912,311,816,780,138,625,810,364,745,857,530,817,591,212,124,445,618,388,681,221,937,96,58,462,834,252,164,376,486,363,28,763,20,419,419,517,991,500,858,772,868,706,672,229,552,724,875,819,902,482,236,897,822,222,538,827,254,180,629,454,984,171,820,772,858,689,986,492,116,896,181,405,892,697,188,493,535,825,818,893,997,544,963,424,470,364,921,57,616,313,565,513,496,926,632,650,732,423,76,130,727,328,953,146,311,586,487,297,812,24,684,882,597,533,117,385,95,97,842,1000,209,237,965,74,154,208,51,625,174,576,9,357,444,265,538,687,292,693,364,28,308,137,466,611,208,4,329,631,177,484,878,480,480,361,351,106,690,705,510,889,550,504,665,522,471,296,235,93,39,832,378,296,514,304,85,940,370,345,284,822,481,743,408,195,962,214,66,540,454,404,428,717,504,704,115,368,311,686,596,940,591,19,865,370,904,569,655,803,601,358,871,348,773,821,620,948,971,524,879,353,400,379,387,118,104,979,844,601,322,968,647,435,981,241,441,142,870,136,584,410,488,746,197,756,625,862,434,524,887,605,942,190,340,36,131,291,168,437,754,12,173,83,157,862,115,819,549,285,804,992,364,714,748,83,919,2,453,664,742,6,27,142,74,434,768,786,137,486,13,521,937,819,633,703,654,461,231,306,798,322,86,548,653,646,478,360,511,522,708,1,667,592,393,786,198,870,930,357,938,28,639,6,372,625,255,956,701,314,901,234,542,963,25,746,324,262,208,535,342,830,62,796,477,529,174,569,424,622,102,814,101,644,161,961,439,799,306,536,641,56,573};

    System.out.println(maximumLengthV1(arr, 20));
  }
  public int maximumLength(int[] nums, int k) {
    len = nums.length;
    this.nums = nums;
    int[][] dp = new int[len][k + 1];
    //dp[i][j] 表示以nums[i]结尾的数组中， num[seq] != num[seq + 1] 不超过j个
    for(int[] arr : dp) {
      Arrays.fill(arr, 1);
    }
    for (int i = 1; i < len; i++) {

    }
    return dp[len][k];
  }

  int[] nums;
  int len;
  Map<String, Integer> map;

  public int maximumLengthV1(int[] nums, int k) {
    len = nums.length;
    this.nums = nums;
    map = new HashMap<>();
    return dfs(len - 1, 0, k);
  }

  /**
   *
   * @param index 当前索引
   * @param lastNum 上一次选中的值，lastNum为0表示上一次没选
   * @param k
   * @return
   */
  private int dfs(int index, int lastNum, int k) {
    String key = String.join(",", List.of(String.valueOf(index), String.valueOf(lastNum), String.valueOf(k)));
    if (map.containsKey(key)) {
      return map.get(key);
    }
    if (index < 0) {
      return 0;
    }
    int res = 0;
    if (k == 0) {
      //表示只能选和lastNum一样的数字
      if (lastNum == 0) {
        //上一次没选
        //这一次选
        res = Math.max(res, 1 + dfs(index - 1, nums[index], k));
        //这一次不选
        res = Math.max(res, dfs(index - 1, lastNum, k));
      } else {
        //上次选了 只能选和上次一样的值
        if (nums[index] == lastNum) {
          res = Math.max(res, 1 + dfs(index - 1, lastNum, k));
        } else {
          //这次只能跳过
          res = Math.max(res, dfs(index - 1, lastNum, k));
        }

      }
    } else {
      if (lastNum == 0) {
        //上一次没选
        //这一次选
        res = Math.max(res, 1 + dfs(index - 1, nums[index], k));

        //这一次不选
        res = Math.max(res, dfs(index - 1, lastNum, k));
      } else {
        if (nums[index] == lastNum) {
          res = Math.max(res, 1 + dfs(index - 1, lastNum, k));
        } else {
          //跳过
          res = Math.max(res, dfs(index - 1, lastNum, k));
          //选
          res = Math.max(res, 1 + dfs(index-1, nums[index], k-1));
        }
      }
    }
    map.put(key, res);
    return res;
  }
}
