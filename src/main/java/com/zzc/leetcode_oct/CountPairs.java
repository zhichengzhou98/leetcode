package com.zzc.leetcode_oct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-21 20:15
 */
public class CountPairs {
    public static void main(String[] args) {

    }

    public long countPairs(int n, int[][] edges) {

        //每个点直接相连的点
        List[] lists = new List[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<Integer>();
        }
        for(int[] pairs : edges) {
            int node1 = pairs[0];
            int node2 = pairs[1];
            lists[node1].add(node2);
            lists[node2].add(node1);
        }
        //
        List<Integer> res = new ArrayList<>();
        //是否访问
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                //如果当前点没有被访问过
                set = new HashSet<>();
                dfs(i, lists, isVisited);
                res.add(set.size());
            }
        }
        long cnt = 0L;
        for (int i = 1; i < res.size(); i++) {
            Integer pre = res.get(i - 1);
            n = n - pre;
            cnt = cnt + (long)pre * n;
        }
        return cnt;
    }


    Set<Integer> set;

    public void dfs(int node, List[] list, boolean[] isVisited) {
        //当前结点已经被访问
        isVisited[node] = true;
        set.add(node);
        //获取与当前结点直接相连的结点
        List<Integer> nextNodes = list[node];
        for (int i = 0; i < nextNodes.size(); i++) {
            Integer next = nextNodes.get(i);
            if (!isVisited[next]) {
                dfs(next, list, isVisited);
            }
        }
    }
}
