package com.zzc.weekcompetition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-03 11:29
 */
public class CountInterestingSubarrays {
    public static void main(String[] args) {
        List<Integer> list = List.of(4, 5);
        System.out.println(countInterestingSubarrays(list, 1, 0));
    }

    public static long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        //s[i + 1] 为 nums 中前i项，满足 nums.get(i) % modulo == k 的个数
        int[] s = new int[nums.size() + 1];
        for (int i = 1; i < s.length; i++) {
            s[i] = s[i - 1] + (nums.get(i - 1) % modulo == k ? 1 : 0);
        }
        //key为s[i] value为值为s[i]出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(s[0] % modulo, 1);

        //(s[i + 1] - s[j]) % m == k <==> (s[i + 1] - k) % m == s[j] % m
        //j <= i
        long res = 0L;
        for (int i = 0; i < nums.size(); i++) {
            int sj = (s[i + 1] - k + modulo) % modulo;
            res = res + map.getOrDefault(sj, 0);
            //放在for循环外，无法保证sj 对应的下标j<= i
            map.put(s[i + 1] % modulo, map.getOrDefault(s[i + 1] % modulo, 0) + 1);
        }
        return res;
    }
}
