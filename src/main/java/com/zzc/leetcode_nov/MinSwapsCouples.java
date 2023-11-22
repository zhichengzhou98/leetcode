package com.zzc.leetcode_nov;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 765. 情侣牵手
 * @create 2023-11-11 20:55
 */
public class MinSwapsCouples {
    public static void main(String[] args) {
        MinSwapsCouples mSC = new MinSwapsCouples();
        int[] res = {0,2,1,3};
        System.out.println(mSC.minSwapsCouples(res));
    }
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int res = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len/ 2; i++) {
            int m = 2 * i;
            int n = m + 1;
            set.add(m + "," + n);
            set.add(n + "," + m);
        }
        for (int i = 0; i < row.length; i+=2) {
            String key = row[i] + "," + row[i +1];
            if (!set.contains(key)) {
                res++;
            }
        }
        return Math.max(0, res-1);
    }
}
