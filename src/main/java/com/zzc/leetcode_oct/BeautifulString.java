package com.zzc.leetcode_oct;

import java.util.HashMap;
import java.util.Map;

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
        System.out.println(bS.beautifulString("1000000111111111101111011000111101001011000011110000110011100010011011111001001001000010000110111101011110010110111101011110101110001000110101010110001111100000100000100011110110100010111010101101001110111111010111100000111110010010101101100111010011001110010010101000000100011100010001101000111000100000001000000110000010001001101101001111101111100110100000011101011001110011001010101001010101010110111001011110100010011001101101101101000100100100101101101110110110100011010101100100001111000110011110011101000110001001100001011101000011110000110101111010000100011001001110101110100101100001101010100001011101101111001101001110011101011010000001110100110010100100001001101110001000011110000110010011010000110010010110011111101110111011001011000111010101000101111011001000110011011001101101010010000010101001100101001101000011001011011101101111110100101000000100000010111000111000001100001001011001110110000111110001100010010111110001101111000101110101000100100110001110100000011001010111000100100101"));
        System.out.println(bS.beautifulString("1100111110010110111111100110101110100110010001101000010011110110100001111110101000111011011001010001101101110011101100101001011101110010011011001001000000000000111100000101011110111100001111110001011100110101011111111100011110010101010111100101100111010001100011111100001100010110101011111011001100111111111100101010000001110100001000011111100101001110101110110110110101111011100011001100101001001001111011011001100100111001001010100000001001101101100101101100100011100010011101110001010010011111001101100111101110100110000111010001100111001100100111111100011011110011001101001110101000000011101000100011011011011011000011010001011010101011101000010110110000010111111110000111111100000100001100100000100100000011011111001100011101100001100110101111010101010000101110011110101001000101011101000101110001100010011110010100001010100100111011000111110000011011011100011111100110101010110000011100010010011111010000001100000111100011001101110100011011111011100001001000001011111000001001111011000100010000"));
    }
    public static final int MOD = 998244353;

    Map<Integer, Integer> jieChengMap;

    public int beautifulString(String s) {
        jieChengMap = new HashMap<>();
        long res = 0;
        int cntOne = 0;
        long lastJieCheng = 1;
        jieChengMap.put(0, 1);
        for (int i = 1; i < s.length(); i++) {
            lastJieCheng = lastJieCheng * i % MOD;
            jieChengMap.put(i, (int)lastJieCheng);
        }
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
    public long modPow(long x, long y) {
        if (y == 0) {
            return 1;
        }
        long result = 1;
        x = x % MOD;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % MOD;
            }
            y = y >> 1; // y = y / 2
            x = (x * x) % MOD;
        }
        return result;
    }

    // 计算组合数C(n, k)对MOD取模  n!/(k! * (n - k)!)
    public long zuHe(int n, int k) {

        long fenZi = jieChengMap.get(n);
        long fenMu = (long) jieChengMap.get(k) * jieChengMap.get(n - k) % MOD;
        long res = (fenZi * modInverse(fenMu)) % MOD;
        return res;
    }
    //求逆元
    public  long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    //时间复杂度 n * k
    /*public long zuHe(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
                }
            }
        }
        return dp[n][k];
    }*/
}
