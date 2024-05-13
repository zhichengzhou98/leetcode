package com.zzc.leetcode_may;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description 滑动窗口
 * @create 2024-05-10 13:46
 */
public class MaxLengthSequence {

    @Test
    public void testFun() {
        System.out.println(maxLengthSequence("anviaj"));
    }

    public int maxLengthSequence(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int maxRes = 1;
        int left = 0;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(left));
        for (int i = 1; i < s.length(); i++) {
            //枚举右端点
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left));
                left++;
                set.add(s.charAt(i));
            }
            if (i < s.length()) {
                maxRes = Math.max(maxRes, i - left + 1);
            }
        }
        return maxRes;
    }
}
