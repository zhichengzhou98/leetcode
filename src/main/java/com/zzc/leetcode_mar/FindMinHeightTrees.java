package com.zzc.leetcode_mar;

import com.zzc.backtracking.IsAdditiveNumber;
import com.zzc.utils.ArrayUtils;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-03-17 16:34
 */
public class FindMinHeightTrees {

    @Test
    public void tetsFun() throws IOException {
        int[][] edges = ArrayUtils.generate("array2", int[][].class);
        System.out.println(findMinHeightTrees(6, edges));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        List<Integer>[] nodes = new List[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            nodes[edge[0]].add(edge[1]);
            nodes[edge[1]].add(edge[0]);
        }
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int x = findMaxDistance(0, nodes, new boolean[n], parent);
        int y = findMaxDistance(x, nodes, new boolean[n], parent);

        //找出x y 之间的路径
        parent[x] = -1;
        List<Integer> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int m = path.size();
        if (m % 2 == 0) {
            ans.add(path.get(m / 2 - 1));
        }
        ans.add(path.get(m / 2));
        return ans;

    }

    //找到当前节点的最远节点
    public int findMaxDistance(int currentNode, List<Integer>[] node, boolean[] isVisited, int[] parent) {
        //使用队列 先进先出
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(currentNode);
        int res = currentNode;
        isVisited[currentNode] = true;
        while (!queue.isEmpty()) {
            Integer pop = queue.poll();
            res = pop;
            List<Integer> list = node[pop];
            if (list != null && !list.isEmpty()) {
                for(int i : list) {
                    if (!isVisited[i]) {
                        isVisited[i] = true;
                        queue.offer(i);
                        parent[i] = pop;
                    }
                }
            }
        }
        return res;
    }


    //超时！！！o(n²)
    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        Map<Integer, Set<Integer>> nodeMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (nodeMap.containsKey(edge[0])) {
                nodeMap.get(edge[0]).add(edge[1]);
            }else {
                Set<Integer> set = new HashSet<>();
                set.add(edge[1]);
                nodeMap.put(edge[0], set);
            }
            if (nodeMap.containsKey(edge[1])) {
                nodeMap.get(edge[1]).add(edge[0]);
            }else {
                Set<Integer> set = new HashSet<>();
                set.add(edge[0]);
                nodeMap.put(edge[1], set);
            }
        }
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            res.put(i,  minDepth(i, nodeMap, visited));
        }
        Integer i = res.values().stream().min(Integer::compareTo).get();
        List<Integer> collect = res.keySet().stream().filter(key -> res.get(key).intValue() == i)
            .collect(Collectors.toList());
        return collect;
    }


    //求当前节点的最小深度
    public int minDepth(int node, Map<Integer, Set<Integer>> nodeMap, boolean[] visited) {
        //求出当前节点的下一个节点
        //当前节点已经被访问
        visited[node] = true;
        int depth = 0;
        Set<Integer> nexts = nodeMap.get(node);
        if (nexts == null || nexts.isEmpty()) {
            return 0;
        }
        for(Integer next : nexts) {
            if (!visited[next]) {
                depth = Math.max(depth, minDepth(next, nodeMap, visited) + 1);
            }
        }
        return depth;
    }

}
