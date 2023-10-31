package com.zzc.leetcode_oct;

import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-29 17:30
 */
public class HIndex {
    public static void main(String[] args) {

    }

    public int hIndex(int[] citations) {
        //差分数组
        int[] diff = new int[1002];
        for(int i : citations) {
            diff[1]++;
            diff[i+1]--;
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] = diff[i - 1] + diff[i];
        }
        for (int i = diff.length - 1; i >=1 ; i--) {
            if (diff[i] >= i) {
                return i;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        System.out.println(hIndexII(new int[]{0,0,0,0}));
    }
    //citations已经是升序
    //二分法查找左边界
    public int hIndexII(int[] citations) {
        int l = 0;
        int r = citations.length - 1;
        int med = (r - l + 1 )/ 2 + l;
        if (citations[citations.length - 1] == 0) {
            return 0;
        }
        while (l < r) {
            if (checkMedLeft(med, citations)) {
                r = med;
            } else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return citations.length - med;

    }

    public boolean checkMedLeft(int med,int[] citations) {
        int h = citations[med];
        int delt = citations.length - med;
        if (h >= delt) {
            return true;
        }
        return false;
    }
}
