package com.zzc.leetcode;

import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-30 10:59
 */
public class HalvesAreAlike {
    public static void main(String[] args) {

    }
    public boolean halvesAreAlike(String s) {
        Set<Character> charSet = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int left = 0;
        int diffCount = 0;
        int right = s.length() - 1;
        while (right > left) {
            if (charSet.contains(s.charAt(left))) {
                diffCount++;
            }
            if (charSet.contains(s.charAt(right))){
                diffCount--;
            }
            left++;
            right--;
        }
        return diffCount == 0;
    }
}
