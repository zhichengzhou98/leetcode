package com.zzc.leetcode_sep;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-26 8:34
 */
public class PassThePillow {
    public static void main(String[] args) {

    }
    public int passThePillow(int n, int time) {
        int i = 1;
        boolean dir = true;
        time = time % (2 * n - 2);
        while (time > 0) {
            if (i == 1) {
                i++;
                time--;
                dir = true;
            }else if (i < n && dir) {
                i++;
                time--;
            }else if (i < n && !dir) {
                i--;
                time--;
            }else if (i == n){
                i--;
                time--;
                dir = false;
            }
        }
        return i;
    }
}
