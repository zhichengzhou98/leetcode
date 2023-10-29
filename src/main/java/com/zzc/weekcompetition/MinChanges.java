package com.zzc.weekcompetition;

import com.zzc.backtracking.PermuteUnique;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-28 22:41
 */
public class MinChanges {
    @Test
    public void test() {
        System.out.println(minChanges("1100"));
    }
    public int minChanges(String s) {
        int res =0;
        int size = s.length();
        for (int i = 0; i < size; ) {
            if (s.charAt(i) != s.charAt(i +1)) {
                res++;
            }
            i += 2;
        }
        return res;
    }
}
