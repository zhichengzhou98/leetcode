package com.zzc.leetcode_nov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-26 11:15
 */
public class UniqueLetterString {
    public static void main(String[] args) {

    }

    public int uniqueLetterString(String s) {
        int res = 0;
        //统计每个字符出现的位置
        int len = s.length();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            }else {
                map.put(c, new ArrayList<>(List.of(-1, i)));
            }
        }
        for(Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            value.add(len);
            for (int i = 1; i < value.size() - 1; i++) {
                int pre = value.get(i-1);
                int current = value.get(i);
                int next = value.get(i + 1);
                res = (current - pre) * (next - current) + res;
            }
        }
        return res;
    }
}
