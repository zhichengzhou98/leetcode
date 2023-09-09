package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-16 22:55
 */
public class BinaryGap {
    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.binaryGap(6));
    }
    public int binaryGap(int n) {
        if ((n - 1 & n) == 0) {
            return 0;
        }
        int maxGap = 0;
        String binaryString = Integer.toBinaryString(n);
        for(int i = 0; i < binaryString.length(); ) {
            if (binaryString.charAt(i) == '1') {
                int j = i + 1;
                while (j < binaryString.length() && binaryString.charAt(j) != '1') {
                    j++;
                }
                if (j < binaryString.length()) {
                    maxGap = Math.max(maxGap, j -i);
                }
                i = j;
            }else {
                i++;
            }
        }
        return maxGap;
    }
}
