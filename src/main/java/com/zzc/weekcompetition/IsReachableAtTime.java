package com.zzc.weekcompetition;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-10 10:35
 */
public class IsReachableAtTime {
    public static void main(String[] args) {

    }

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
       int deleX = Math.abs(fx - sx);
       int deleY = Math.abs(fy - sy);
       if (deleY > t || deleX > t) {
           return false;
       }
       if (sx == fx && sy == fy && t == 1) {
           return false;
       }

       //int min = Math.min(deleX, deleY);
       //int total = Math.max(deleX, deleY);
       return true;
    }
}
