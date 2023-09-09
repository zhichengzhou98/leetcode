package com.zzc.weekcompetition;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-27 10:32
 */
public class FurthestDistanceFromOrigin {
    public static void main(String[] args) {

    }

    public int furthestDistanceFromOrigin(String moves) {
        int LCount = 0;
        int RCount = 0;
        int symbolCount = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                LCount++;
            }else if (moves.charAt(i) == 'R') {
                RCount++;
            }else {
                symbolCount++;
            }
        }
        return Math.abs(LCount-RCount) + symbolCount;
    }
}
