package com.zzc.leetcode_sep;

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-16 15:09
 */
public class CarFleet {
    public static void main(String[] args) {
        CarFleet cf = new CarFleet();
        //int[] pos = {10,8,0,5,3};
        int[] pos = {4,0,5,3,1,2};
        //int[] speed = {2,4,1,1,3};
        int[] speed = {6,10,9,6,7,2};
        System.out.println(cf.carFleet(12, pos, speed));
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] posAndSpeed = new int[position.length][2];
        for (int i = 0; i < posAndSpeed.length; i++) {
            posAndSpeed[i][0] =  position[i];
            posAndSpeed[i][1] = speed[i];
        }
        Arrays.sort(posAndSpeed, (a, b) -> a[0] - b[0]);
        int res = 1;
        int[] after = posAndSpeed[posAndSpeed.length - 1];
        for (int i = posAndSpeed.length - 1; i >= 1 ; i--) {
            int[] before = posAndSpeed[i - 1];
            double timeBefore = (double) (target - before[0]) / before[1];
            double timeAfter = (double)(target - after[0]) / after[1];
            if (before[0] == after[0]) {
                after[1] = Math.min(before[1], after[1]);
            }else if (timeAfter < timeBefore){
                //前一辆车没追上后一辆， 车队数 + 1
                after = before;
                res++;
            }
        }
        return res;
    }
}
