package com.zzc.leetcode_mar;

import com.zzc.utils.ArrayUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-03-27 22:14
 */
public class CountWays {
    @Test
    public void test() throws IOException {
        int[][] array2 = ArrayUtils.generate("array2", int[][].class);
        System.out.println(countWays(array2));
    }

    public int countWays(int[][] ranges) {
        //第一个元素升序
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(ranges[0]);
        for (int i = 1; i < ranges.length; i++) {
            int[] currentRange = ranges[i];
            int pre = currentRange[0];
            int[] lastRange = list.get(list.size()-1);
            if (pre <= lastRange[1]){
                lastRange[1] = Math.max(lastRange[1], currentRange[1]);
            }else {
                list.add(currentRange);
            }
        }
        int n = list.size();
        //求2的n次幂
        return (int) exponentiationBySquaring(2, n);
    }

    //
    public static int MOD = (int) (Math.pow(10, 9) + 7);


    public long exponentiationBySquaring(int a, int b) {
        //求a的b次幂
        if (b == 1) {
            return a % MOD;
        }

        if (b % 2 == 0) {
            long x = exponentiationBySquaring(a, b/2) % MOD;
            return x * x % MOD;
        }
        long y = exponentiationBySquaring(a, (b-1)/2) % MOD;
        return y * y % MOD * a % MOD;
    }
}
