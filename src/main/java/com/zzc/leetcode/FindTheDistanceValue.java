package com.zzc.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author zc.zhou
 * @Description 1385. 两个数组间的距离值
 * @create 2023-08-03 12:31
 */
public class FindTheDistanceValue {
    public static void main(String[] args) {
        System.out.println(findTheDistanceValue(new int[] {1,4,2,3}, new int[]{-4,-3,6,10,20,30}, 3));
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        Arrays.sort(arr2);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j <= d; j++) {
                set.add(arr2[i]-j);
                set.add(arr2[i]+j);
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!set.contains(arr1[i])) {
                count++;
            }
        }
        return count;
    }
}
