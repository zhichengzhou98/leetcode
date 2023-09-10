package com.zzc.leetcode_sep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-09 22:19
 */
public class NumFriendRequests {
    public static void main(String[] args) {
        //int[] arr = {6, 6, 15, 26, 30, 35, 39, 46, 60, 71, 73, 100, 106, 110, 112};
        int[] arr = {5, 6};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(numFriendRequests(arr));
    }

    public static int numFriendRequests(int[] ages) {
        //统计每个年龄的人数
        // x >= y >  0.5x + 7 => x, y >= 15
        int[] cnts = new int[120];
        Set<Integer> ageSet = new HashSet<>();
        for (int i = 0; i < ages.length; i++) {
            //下标 i = age - 1
            if (ages[i] >= 15) {
                cnts[ages[i] - 1]++;
                ageSet.add(ages[i]);
            }
        }
        int count = 0;
        for (int i = 0; i < cnts.length; i++) {
            int teen = cnts[i];
            //y > 0.5x + 7， x = y 时 y > 14, 年龄至少15岁， age - 1 = i
            if (teen >= 2 && i >= 14) {
                //同年龄之间可以相互发消息
                count = count + (teen - 1 ) * teen;
            }
        }
        //由于age范围为[1, 120], set最多120个元素，双重for问题不大
        int[] ageArray = ageSet.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(ageArray);
        for (int i = ageArray.length - 1; i >= 1; i--) {
            int x = ageArray[i];
            for (int j = i - 1; j >= 0; j--) {
                int y = ageArray[j];
                //数组已经是升序了， x >= y 一定满足
                if (y > 0.5 * x + 7) {
                    //x y 能发消息
                    count = count + cnts[x - 1] * cnts[y - 1];
                }
            }
        }
        return count;
    }
}
