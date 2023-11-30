package com.zzc.leetcode_nov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 2948. 交换得到字典序最小的数组
 * @create 2023-11-28 21:35
 */
public class LexicographicallySmallestArray {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new int[]{nums[i], i});
        }
        Collections.sort(list,(a, b) -> a[0] - b[0]);
        int i = 0;
        int k = 0;
        while (i < list.size()) {
            int st = i;
            i++;
            List<Integer> tempList = new ArrayList<>();
            tempList.add(list.get(st)[1]);
            while (i < list.size() && (list.get(i)[0] -list.get(i-1)[0])<= limit) {
                tempList.add(list.get(i)[1]);
                i++;
            }
            Collections.sort(tempList);
            for (int j = 0; j < tempList.size(); j++) {
                nums[tempList.get(j)] = list.get(k)[0];
                k++;
            }
        }

        return nums;
    }
}
