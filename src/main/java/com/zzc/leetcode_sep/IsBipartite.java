package com.zzc.leetcode_sep;



import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-05 21:04
 */
public class IsBipartite {
    public static void main(String[] args) {
        //System.out.println(isBipartite(new int[][]{{1},{0},{4},{4},{2,3}}));
        //System.out.println(isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));
        System.out.println(isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
    }
    public static boolean isBipartite(int[][] graph) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for (int i = 0; i < graph.length; i++) {
            boolean[] isVisited = new boolean[graph.length];
            if (!isVisited[i]) {
                isVisited[i] = true;
                //与当前结点相连的结点
                int[] current = graph[i];
                if (current.length != 0) {
                    //广度优先搜索， 从当前结点开始
                    //假设当前结点属于 setA 0->A 1->B
                    int nextP = 0;
                    if (setA.contains(i) && setB.contains(i)) {
                        return false;
                    }else if (setB.contains(i)) {
                        nextP = 0;
                    }else if (setA.contains(i)){
                        nextP = 1;
                    }else {
                        setA.add(i);
                        nextP = 1;
                    }

                    List<int[]> list = new ArrayList<>();
                    //则下面都是setB
                    for (int k : current) {
                        if (!isVisited[k]) {
                            list.add(new int[]{k, nextP});
                            isVisited[k] = true;
                        }
                    }
                    while (!list.isEmpty()) {
                        int size = list.size();
                        for (int j = 0; j < size; j++) {
                            //下一个结点为next[0], 放到next[1]
                            int[] next = list.remove(0);
                            int node = next[0];
                            int position = next[1];
                            if (position == 0) {
                                setA.add(node);
                            }else {
                                setB.add(node);
                            }
                            for (int k : graph[node]) {
                                if (!isVisited[k]) {
                                    list.add(new int[]{k, Math.abs(1- position)});
                                    isVisited[k] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        //取交集， 为空则没有交集
        setB.retainAll(setA);
        return setB.isEmpty();
    }


}
