package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-29 18:58
 */
public class CheckAlmostEquivalent {
    public static void main(String[] args) {

    }

    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] charCount = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            charCount[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            charCount[word2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < charCount.length; i++) {
            if (Math.abs(charCount[i]) > 3) {
                return false;
            }
        }
        return true;
    }
}
