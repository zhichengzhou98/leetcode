package com.zzc.leetcode_dec;

import com.zzc.utils.ArrayUtils;

import java.io.IOException;
import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-07 12:08
 */
public class MinReorder {
    public static void main(String[] args) throws IOException {
        int[][] arr = ArrayUtils.generate("array", int[][].class);
        MinReorder mR = new MinReorder();
        System.out.println(mR.minReorder(6, arr));

    }

    int res;
    Map<Integer, Set<Integer>> beginMap;
    Map<Integer, Set<Integer>> endMap;

    public int minReorder(int n, int[][] connections) {
        //key 为起点
        beginMap = new HashMap<>();
        //key 为终点
        endMap = new HashMap<>();
        for (int[] pair : connections) {
            int begin = pair[0];
            int end = pair[1];
            if (beginMap.containsKey(begin)) {
                beginMap.get(begin).add(end);
            } else {
                Set<Integer> list = new HashSet<>();
                list.add(end);
                beginMap.put(begin, list);
            }
            if (endMap.containsKey(end)) {
                endMap.get(end).add(begin);
            } else {
                Set<Integer> list = new HashSet<>();
                list.add(begin);
                endMap.put(end, list);
            }
        }
        dfs(0, -1);
        return res;
    }

    public void dfs(Integer i, int pre) {
        if (beginMap.containsKey(i)) {
            Set<Integer> set = beginMap.get(i);
            //set.remove(pre);
            res += set.size();
            if (set.contains(pre)) {
                res -= 1;
            }
            for (int k : set) {
                if (k != pre) {
                    dfs(k, i);
                }
            }
        }
        if (endMap.containsKey(i)) {
            Set<Integer> set = endMap.get(i);
            for (int k : set) {
                if (k!=pre) {
                    dfs(k, i);
                }
            }
        }
    }
}
