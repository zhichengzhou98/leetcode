package com.zzc.leetcode_dec;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-19 22:19
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {

    }

    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        //统计窗口中字符出现的次数
        int[] cnts = new int[128];
        int res = 0;
        int l = 0;
        //枚举右端点
        for (int r = 0; r < s.length(); r++) {
            while (cnts[s.charAt(r)] > 0) {
                cnts[s.charAt(l)]--;
                l++;
            }
            cnts[s.charAt(r)]++;
            res = Math.max(res, r - l +1);
        }
        return res;
    }
}
