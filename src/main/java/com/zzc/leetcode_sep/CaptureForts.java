package com.zzc.leetcode_sep;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-02 7:07
 */
public class CaptureForts {
    public static void main(String[] args) {
        System.out.println(captureForts(new int[]{1,0,0,-1,0,0,0,0,1}));
    }

    //找1和-1直接距离的最大值
    public static int captureForts(int[] forts) {
        int i = 0;
        int res = 0;
        while (i < forts.length) {
            while (i < forts.length && forts[i] == 0) {
                i++;
            }

            if (i == forts.length) {
                return res;
            }
            int des = 1;
            if (forts[i] == 1) {
                //找 -1
                des  = -1;
            }
            int j = i + 1;
            while (j <forts.length && forts[j] == 0) {
                j++;
            }
            if (j == forts.length) {
                return res;
            }else if (forts[j] == des) {
                //找到了
                res = Math.max(j - i - 1, res);
            }
            // 没找到，forts[i] == forts[j]
            i = j;
        }

        return res;
    }
}
