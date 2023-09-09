package com.zzc.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zc.zhou
 * @Description 1356. 根据数字二进制下 1 的数目排序
 * @create 2023-08-01 12:09
 */
public class SortByBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
    }

    public static int[] sortByBits(int[] arr) {
        Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(array, (o1, o2) -> numOfOne(o1) == numOfOne(o2) ? o1 - o2 : numOfOne(o1) - numOfOne(o2));
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }

    public static int numOfOne(Integer n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
