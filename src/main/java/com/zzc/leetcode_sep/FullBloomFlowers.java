package com.zzc.leetcode_sep;

import com.zzc.utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-28 12:21
 */
public class FullBloomFlowers {
    public static void main(String[] args) throws Exception {
        int[][] f = ArrayUtils.generate("array", int[][].class);
        int[] p = ArrayUtils.generate("array1", int[].class);
        FullBloomFlowers fBF = new FullBloomFlowers();
        System.out.println(Arrays.toString(fBF.fullBloomFlowers(f, p)));
    }
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < flowers.length; i++) {
            maxTime = Math.max(maxTime, flowers[i][1]);
        }
        int[] diff = new int[maxTime + 2];
        for (int i = 0; i < flowers.length; i++) {
            int next = flowers[i][1];
            next++;
            diff[flowers[i][0]]++;
            diff[next]--;
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] = diff[i - 1] + diff[i];
        }
        int[] res = new int[people.length];
        for (int i = 0; i < res.length; i++) {
            if (people[i] >= diff.length) {
                res[i] = 0;
            }else {
                res[i] = diff[people[i]];
            }
        }
        return res;
    }
}
