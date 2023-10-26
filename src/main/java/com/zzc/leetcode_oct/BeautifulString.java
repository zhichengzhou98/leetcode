package com.zzc.leetcode_oct;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-26 12:03
 */
public class BeautifulString {
    public static void main(String[] args) {
        BeautifulString bS = new BeautifulString();
        //954957892
        System.out.println(bS.beautifulString("0100111000100001111101111011010011110101001101110111001101110000110001110101110000000000010101111110"));
    }
    public static final int MOD = 998244353;

    public int beautifulString(String s) {
        double res = 0;
        int cntOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cntOne++;
            }
            String sub = s.substring(0, i + 1);
            res = (res + calBeautifulCnt(sub, cntOne, s.charAt(i))) % MOD;
        }
        return (int) res;
    }

    public int calBeautifulCnt(String s, int cntOne, char lastChar) {
        int len = s.length();
        int newLen = 2 * len - 1;
        int blank = newLen - len;
        double res = 0;
        if (lastChar == '0') {
            // 0 的个数至少为 len
            //已有 0 的个数
            int existZero = len - cntOne;
            if (existZero >= len) {
                return (int) (Math.pow(2, blank) % MOD);
            }else if (existZero + blank < len) {
                return 0;
            }
            //至少需要
            int needZero = len - existZero;
            for (int i = needZero; i <= blank; i++) {
                res = (res + zuHe(blank, i)) % MOD;
            }
            return (int) res;
        }else {
            // 1 的个数至少为 len
            if (cntOne >= len) {
                return (int) (Math.pow(2, blank) % MOD);
            }else if (cntOne + blank < len) {
                return 0;
            }
            //至少需要
            int needOne = len - cntOne;
            for (int i = needOne; i <= blank; i++) {
                res = (res + zuHe(blank, i)) % MOD;
            }
            return (int) res;
        }
    }

    public int zuHe(int num1, int num2) {
        int min = Math.min(num2, num1 - num2);
        int temp = min;
        double res = 1.0;
        while (min > 0) {
            res = res * num1;
            num1--;
            min--;
        }
        for (int i = 1; i <= temp; i++) {
            res /= i;
        }
        return (int) (res % MOD);
    }
}
