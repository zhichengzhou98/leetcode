package com.zzc.leetcode_nov;

import com.zzc.utils.ArrayUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-08 21:48
 */
public class MaximumScoreAfterOperations {
    @Test
    public void test() {
        try {
            int[][] array = ArrayUtils.generate("array", int[][].class);
            //int[] values = {2,16,23,17,22,21,8,6};
            int[] values = {2,16};
            int i = Arrays.stream(values).sum() - 22;
            //System.out.println(i);
            System.out.println(maximumScoreAfterOperations(array, values));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getNext(Set<Integer>[] nexts, int pre, int current) {
        Set<Integer> next = nexts[current];
        if (!next.isEmpty()) {
            next.remove(pre);
            for (int i : next) {
                getNext(nexts, current, i);
            }
        }
    }
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        map = new HashMap<>();
        Set<Integer>[] next = new Set[values.length];
        //TODO 需要重新获取next结点
        for (int i = 0; i < next.length; i++) {
            next[i] = new HashSet<>();
        }
        for(int[] arr : edges) {
            next[arr[0]].add(arr[1]);
            next[arr[1]].add(arr[0]);
        }
        getNext(next, -1, 0);
        return dfs(next, values, true, 0);
    }
    Map<String, Long> map;
    public long dfs(Set<Integer>[] next, int[] values, boolean flag, int root) {
        String key = (flag ? "1," : "0,") + root;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (flag) {
            Set<Integer> n = next[root];
            if (n.isEmpty()) {
                return 0L;
            }
            //当前不加入
            long res1 = 0L;
            for(int i : n) {
                res1 = res1 + dfs(next, values, false, i);
            }

            //当前加入
            long res2 = values[root];
            for (int i : n) {
                res2 = res2 + dfs(next, values, true, i);
            }
            long res = Math.max(res1, res2);
            map.put("1," + root, res);
            return res;
        }else {
            long res = values[root];
            for (Integer o : next[root]) {
                res = res + dfs(next, values, false, o);
            }
            map.put("0," + root, res);
            return res;
        }
    }
}
