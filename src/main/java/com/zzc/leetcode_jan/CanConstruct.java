package com.zzc.leetcode_jan;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-01-07 11:26
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnts = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            cnts[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = 0; i < magazine.length(); i++) {
            cnts[magazine.charAt(i) - 'a']++;
        }
        for(int cnt : cnts) {
            if (cnt < 0) {
                return false;
            }
        }
        return true;
    }
}
