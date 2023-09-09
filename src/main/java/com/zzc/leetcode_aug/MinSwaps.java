package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-01 12:10
 */
public class MinSwaps {
    public static void main(String[] args) {

    }

    public int minSwaps(String s) {
        int cnt1 = 0; // s与目标字符串之间差异的字符个数，目标字符串: 10101...101,
        int cnt2 = 0; // 01010...010
        int countOne = 0;
        int countZero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOne++;
                if (i % 2 == 0) {
                    cnt2++;
                }else {
                    cnt1++;
                }
            }else {
                countZero++;
                if (i % 2 == 0) {
                    cnt1++;
                }else {
                    cnt2++;
                }
            }
        }
        if (Math.abs(countOne - countZero) >= 2) {
            return -1;
        }else if (Math.abs(countOne - countZero) == 1) {
            if (countOne > countZero) {
                //目标字符串：1010....101
                return cnt1 / 2;
            }else {
                // 010....1010
                return cnt2 / 2;
            }
        }else {
            return Math.min(cnt1 / 2, cnt2 / 2);
        }
    }

    /*public int minSwaps(String s) {
        int cnt = 0;
        int countOne = 0;
        int countZero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOne++;
            }else {
                countZero++;
            }
        }

        if (Math.abs(countOne - countZero) >= 2) {
            return -1;
        }else if (Math.abs(countOne - countZero) >= 1) {
            if (countOne > countZero) {
                // 1010....101
                for (int i = 0; i < s.length(); i++) {
                    if ((i % 2 == 0 &&s.charAt(i) != '1')||
                            (i % 2 == 1 &&s.charAt(i) != '0')) {
                        cnt++;
                    }
                }
                return cnt / 2;
            }else {
                // 010....1010
                for (int i = 0; i < s.length(); i++) {
                    if ((i % 2 == 1 &&s.charAt(i) != '1')||
                            (i % 2 == 0 &&s.charAt(i) != '0')) {
                        cnt++;
                    }
                }
                return cnt / 2;
            }
        }else {
            for (int i = 0; i < s.length(); i++) {
                if ((i % 2 == 0 &&s.charAt(i) != '1')||
                        (i % 2 == 1 &&s.charAt(i) != '0')) {
                    cnt++;
                }
            }
            int cnt2 = 0;
            for (int i = 0; i < s.length(); i++) {
                if ((i % 2 == 1 &&s.charAt(i) != '1')||
                        (i % 2 == 0 &&s.charAt(i) != '0')) {
                    cnt2++;
                }
            }

            return Math.min(cnt / 2, cnt2 / 2);
        }
    }*/
}
