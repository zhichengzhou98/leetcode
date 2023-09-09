package com.zzc.leetcode_aug;

import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-23 20:40
 */
public class CountPairs {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countPairs1(20, new int[][]{{5,2},{17,5},{18,7},{13,4},{14,13}}, new int[]{0,0,0,1,1,0,0,1,1,0,2,0,0,2,2,4,3,3})));
    }
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] degree = new int[n];
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int[] edge : edges) {
            int x = edge[0] - 1, y = edge[1] - 1;
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            degree[x]++;
            degree[y]++;
            cnt.put(x * n + y, cnt.getOrDefault(x * n + y, 0) + 1);
        }

        int[] arr = Arrays.copyOf(degree, n);
        int[] ans = new int[queries.length];
        Arrays.sort(arr);
        for (int k = 0; k < queries.length; k++) {
            int bound = queries[k], total = 0;
            for (int i = 0; i < n; i++) {
                int j = binarySearch(arr, i + 1, n - 1, bound - arr[i]);
                total += n - j;
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int val = entry.getKey(), freq = entry.getValue();
                int x = val / n, y = val % n;
                if (degree[x] + degree[y] > bound && degree[x] + degree[y] - freq <= bound) {
                    total--;
                }
            }
            ans[k] = total;
        }

        return ans;
    }

    public int binarySearch(int[] arr, int left, int right, int target) {
        int ans = right + 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    /*public static int[] countPairs(int n, int[][] edges, int[] queries) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<String, Integer> repeatNum = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edgs = edges[i];
            map.put(edgs[0], map.getOrDefault(edgs[0], 0) + 1);
            map.put(edgs[1], map.getOrDefault(edgs[1], 0) + 1);
            Arrays.sort(edgs);
            String key = edgs[0] + ","+ edgs[1];
            repeatNum.put(key, repeatNum.getOrDefault(key, 0) + 1);
        }
        HashMap<String, Integer> res = new HashMap<>();
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                String key = i + "," +j;
                res.put(key, map.getOrDefault(i, 0) + map.getOrDefault(j, 0) - repeatNum.getOrDefault(key, 0));
            }
        }
        System.out.println(res);
        int[] result = new int[queries.length];
        for (int i = 0; i < result.length; i++) {
            final int num = queries[i];
            result[i] = (int) res.values().stream().filter(k -> k > num).count();
        }
        return result;
    }*/

    public static int[] countPairs1(int n, int[][] edges, int[] queries) {
        //int[] pairs = new int[n * (n - 1) / 2];

        //System.out.println(res);
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> repeatNum = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edgs = edges[i];
            map.put(String.valueOf(edgs[0]), map.getOrDefault(String.valueOf(edgs[0]), 0) + 1);
            map.put(String.valueOf(edgs[1]), map.getOrDefault(String.valueOf(edgs[1]), 0) + 1);
            Arrays.sort(edgs);
            String key = edgs[0] + ","+ edgs[1];
            repeatNum.put(key, repeatNum.getOrDefault(key, 0) + 1);
        }
        HashMap<String, Integer> res = new HashMap<>();
        int[] array = map.keySet().stream().sorted().mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == array[j]) {
                    continue;
                }
                String key = i < array[j] ? i + "," +array[j] : array[j] + "," + i;
                res.put(key, map.getOrDefault(String.valueOf(i), 0) + map.getOrDefault(String.valueOf(array[j]) , 0) - repeatNum.getOrDefault(key, 0));
            }
        }
        System.out.println(res);
        int[] result = new int[queries.length];
        for (int i = 0; i < result.length; i++) {
            final int num = queries[i];
            result[i] = (int) res.values().stream().filter(k -> k > num).count();
        }
        return result;
    }
    /*public static int[] countPairs(int n, int[][] edges, int[] queries) {
        //int[] pairs = new int[n * (n - 1) / 2];
        HashMap<Set, Integer> res = new HashMap<>();
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                HashSet<Integer> pairs = new HashSet<>();
                pairs.add(i);
                pairs.add(j);
                res.put(pairs, 0);
            }
        }
        //System.out.println(res);
        for (int i = 0; i < edges.length; i++) {
            int[] edgs = edges[i];
            Set<Set> sets = res.keySet();
            for(Set key : sets) {
                //System.out.println(key);
                if (key.contains(edgs[0]) || key.contains(edgs[1])) {
                    res.put(key, res.get(key) + 1);
                }
            }
        }
        //System.out.println(res);
        int[] result = new int[queries.length];
        for (int i = 0; i < result.length; i++) {
            final int num = queries[i];
            result[i] = (int) res.values().stream().filter(k -> k > num).count();
        }
        return result;
    }*/
}
