package com.zzc.leetcode_sep;

import java.util.Arrays;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-03 16:28
 */
public class EliminateMaximum {
    public static void main(String[] args) {
        System.out.println(eliminateMaximum(new int[]{5,4,3,3,3}, new int[]{1,1,5,3,1}));
    }

    public static int eliminateMaximum(int[] dist, int[] speed) {
        //将dist数组转为各个怪兽到达的时间
        for (int i = 0; i < dist.length; i++) {
            dist[i] = (dist[i] - 1) / speed[i] + 1;
        }
        //将dist数组排序
        Arrays.sort(dist);
        //1,1,2,3 ×
        //找出满足dist[i] < i + 1 的最小索引， 返回索引 + 1
        //直接for
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] < i + 1) {
                return i;
            }
        }
        return dist.length;
        //错误解答 并不满足有序 （dist[i] - (i + 1)）
        //dist[i] 1 1 3 4 5
        //i + 1   1 2 3 4 5
        //二分
        //找到dist[i] >=  i + 1 右边界
       /* int left = 0;
        int right = dist.length - 1;
        int med = (right +  left  + 1) / 2;
        while (left < right) {

            if (dist[med] >= med + 1) {
                left = med;
            }else {
                right  = med - 1;
            }
            med = (right +  left  + 1) / 2;
        }
        return med + 1;*/
    }

    //超时
    /*public static int eliminateMaximum(int[] dist, int[] speed) {
        int n = 0;
        int res = 0;
        while (n <= 100000) {
            //check dist
            int k = n;
            boolean flag = false;
            for (int i = 0; i < dist.length; i++) {
                if (dist[i] <=0) {
                    k--;
                }else {
                    flag = true;
                }
                if (k < 0) {
                    return res;
                }
                dist[i] = dist[i] - speed[i];
            }
            if (!flag) {
                return dist.length;
            }
            res++;
            n++;
        }
        return Math.min(res, dist.length);
    }*/
}
