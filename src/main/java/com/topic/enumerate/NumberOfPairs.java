package com.topic.enumerate;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author zc.zhou
 * @Description 3162. 优质数对的总数 I 枚举
 * @create 2024-10-10 8:49
 */
public class NumberOfPairs {

  //o(n²)
  public int numberOfPairsV1(int[] nums1, int[] nums2, int k) {
    int res = 0;
    for (int n1 : nums1) {
      for (int n2 : nums2) {
        if (n1 % (n2 * k) == 0) {
          res++;
        }
      }
    }
    return res;
  }


  @Test
  void testFun() {
    int[] nums1 = {1,3,4};
    int[] nums2 = {1,3,4};
    System.out.println(numberOfPairs(nums1,nums2,1));
  }

  //o(n²)
  public long numberOfPairs(int[] nums1, int[] nums2, int k) {
    //分别统计nums1和nums2中每个数出现的次数
    HashMap<Integer, Integer> cntMap1 = new HashMap<>();
    //nums1最大值
    int max1 = Integer.MIN_VALUE;
    HashMap<Integer, Integer> cntMap2 = new HashMap<>();
    for(int n1 : nums1) {
      cntMap1.put(n1, cntMap1.getOrDefault(n1, 0) + 1);
      max1 = Math.max(max1, n1);
    }
    for(int n2 : nums2) {
      cntMap2.put(n2, cntMap2.getOrDefault(n2, 0) + 1);
    }
    long res = 0;
    //枚举nums2中每一个数
    for (int n2 : cntMap2.keySet()) {
      long tmp = (long) n2 * k;
      //i为倍数
      for (int i = 1; i * tmp <= max1 ; i++) {
        int tar = i * (int) tmp;
        res += (long) cntMap1.getOrDefault(tar, 0) * cntMap2.getOrDefault(n2, 0);
      }
    }
    return res;
  }
}
