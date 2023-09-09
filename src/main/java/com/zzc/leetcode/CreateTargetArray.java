package com.zzc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-09 21:10
 */
public class CreateTargetArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(createTargetArray(
                new int[]{0, 1, 2, 3, 4},
                new int[]{0, 1, 2, 2, 1}
        )));
    }
    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
