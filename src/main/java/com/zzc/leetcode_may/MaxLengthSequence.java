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
        System.out.println(maxLengthSequence("bbbbb"));
    }

    public int maxLengthSequence(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int maxRes = 1;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            //求最大长度，不断将right右移，直到不满足条件
            if (!set.contains(current)) {
                set.add(current);
                maxRes = Math.max(maxRes, right - left + 1);
                continue;
            }
            while (s.charAt(left) != current) {
                set.remove(s.charAt(left));
                left++;
            }
            //此时s.charAt(left) == current, 只需要将left+1, current已经存在于set中
            left++;
        }
        return maxRes;
    }
}
