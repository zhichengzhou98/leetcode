package com.zzc.leetcode_sep;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-30 18:40
 */
public class EarliestFullBloom {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        //0 为 生长时间 1为播种时间
        int[][] gP = new int[plantTime.length][2];
        for (int i = 0; i < gP.length; i++) {
            gP[i] = new int[]{growTime[i], plantTime[i]};
        }
        //按生长时间降序
        Arrays.sort(gP, (a, b) -> b[0] - a[0]);
        int totalPlant = 0;
        int lastGrowTime = 0;
        for (int i = 0; i < gP.length; i++) {
            totalPlant += gP[i][1];
            if (lastGrowTime < totalPlant + gP[i][0]) {
                lastGrowTime = totalPlant + gP[i][0];
            }
        }
        return lastGrowTime;
    }
}
