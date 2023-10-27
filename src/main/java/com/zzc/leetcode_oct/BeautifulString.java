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
        System.out.println(bS.beautifulString("11"));
    }
    public static final int MOD = 998244353;

    public int beautifulString(String s) {
        long res = 0;
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

    public long calBeautifulCnt(String s, int cntOne, char lastChar) {
        int len = s.length();
        int newLen = 2 * len - 1;
        int blank = newLen - len;
        long res = 0;
        if (lastChar == '1') {
            cntOne = len - cntOne;
        }
        for (int i = cntOne; i <= blank; i++) {
            res = (res + zuHe(blank, i)) % MOD;
        }
        return res;
    }

    public long zuHe(int num1, int num2) {
        int min = Math.min(num2, num1 - num2);
        int temp = min;
        long res = 1;
        while (min > 0) {
            res = res * num1;
            num1--;
            min--;
        }
        for (int i = 1; i <= temp; i++) {
            res /= i;
        }
        return res % MOD;
    }
}
