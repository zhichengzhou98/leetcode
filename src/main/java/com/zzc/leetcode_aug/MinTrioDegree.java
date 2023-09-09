package com.zzc.leetcode_aug;

import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-31 21:06
 */
public class MinTrioDegree {
    public static void main(String[] args) {
        System.out.println(minTrioDegree(6, new int[][]{{1,2},{1,3},{3,2},{4,1},{5,2},{3,6}}));
    }

    public static int minTrioDegree(int n, int[][] edges) {
        //每个结点的边（度）
        int[] map = new int[n];
        int[][] g = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            map[edge[0]-1]++;
            map[edge[1]-1]++;
           g[edge[0]-1][edge[1]-1] = g[edge[1]-1][edge[0]-1] = 1;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (g[i-1][j-1] == 1) {
                    for (int k = j+1; k <= n; k++) {
                        if (g[i-1][k-1] == 1 && g[k-1][j-1] == 1) {
                            int temp = map[i-1] + map[k-1] +map[j-1];
                            count = Math.min(count, temp);
                        }

                    }
                }

            }
        }
        if (count == Integer.MAX_VALUE) {
            return -1;
        }
        return count - 6;
    }
    //超时
    /*public static int minTrioDegree(int n, int[][] edges) {
        //key 为结点， value 为与key相连的结点
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            Set<Integer> set1 = map.getOrDefault(edge[0], new HashSet<>());
            set1.add(edge[1]);
            map.put(edge[0], set1);
            Set<Integer> set2 = map.getOrDefault(edge[1], new HashSet<>());
            set2.add(edge[0]);
            map.put(edge[1], set2);
        }
        //连通三元组的集合 使用set 点按升序用 , 分隔
        Set<String> res = new HashSet<>();
        int[] keyArray = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < keyArray.length; i++) {
            //与keyArray[i]连通的点集合
            Set<Integer> set = map.get(keyArray[i]);
            final int first = keyArray[i];
            if (!set.isEmpty()) {
                set.forEach(item -> {
                    Set<Integer> set1 = map.get(item);
                    if (!set1.isEmpty()) {
                        //求set 与  set1的交集
                        HashSet<Integer> integration = new HashSet<>(set1);
                        integration.retainAll(set);
                        if (!integration.isEmpty()) {
                            for(Integer third : integration) {
                                int[] arr = new int[] {first, item, third};
                                Arrays.sort(arr);
                                res.add(arr[0] +"," + arr[1] + "," + arr[2]);
                            }
                        }
                    }
                });
            }
        }

        if (res.isEmpty()) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for(String str : res) {
            String[] split = str.split(",");
            int count = 0;
            for (String s : split) {
                Set<Integer> set = map.getOrDefault(Integer.valueOf(s), new HashSet<>());
                count += set.size();
            }
            min = Math.min(min, count);
        }

        return min - 6;
    }*/
}
