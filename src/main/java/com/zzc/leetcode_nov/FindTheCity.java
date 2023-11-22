package com.zzc.leetcode_nov;

import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-14 20:12
 */
public class FindTheCity {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List[] nexts = new List[n];
        for (int i = 0; i < nexts.length; i++) {
            nexts[i] = new ArrayList<int[]>();
        }
        for(int[] edge: edges) {
            nexts[edge[0]].add(new int[]{edge[1], edge[2]});
            nexts[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int min = Integer.MAX_VALUE;
        int maxIndex = 0;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set1 = new HashSet<>();
            set1.add(-1);
            Set<Integer> set = dfs(set1, i, distanceThreshold, nexts);
            if (set.size() <= min) {
                min = set.size();
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    Map<String, Set<Integer>> map;
    public Set<Integer> dfs(Set<Integer> preNode, int currentNode, int distanceThreshold, List[] nexts) {
        String key = currentNode + "," + distanceThreshold;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        Set<Integer> set = new HashSet<>();
        List<int[]> next = nexts[currentNode];
        for (int i = 0; i < next.size(); i++) {
            int[] ints = next.get(i);
            if (!preNode.contains(ints[0]) && ints[1] <= distanceThreshold) {
                set.add(ints[0]);
                Set<Integer> newSet = new HashSet<>(preNode);
                newSet.add(currentNode);
                set.addAll(dfs(newSet, ints[0], distanceThreshold - ints[1], nexts));
            }
        }
        map.put(key, set);
        return set;
    }
}
