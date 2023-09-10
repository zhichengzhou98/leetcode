package com.zzc.leetcode_sep;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-10 7:58
 */
public class FindOrder {
    public static void main(String[] args) {
        int[] arr = new int[0];
        System.out.println(arr);
    }

    List<Integer> courseOrder;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        courseOrder = new ArrayList<>();
        //List[i] 表示i的前导课程
        List<Integer>[] preCourses = new List[numCourses];
        for (int i = 0; i < preCourses.length; i++) {
            preCourses[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] edge = prerequisites[i];
            preCourses[edge[0]].add(edge[1]);
        }
        //0: 未搜索; 1: 搜索中; 2: 已完成
        int[] isVisited = new int[numCourses];
        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i] == 0) {
                //开始搜索
                if (!dfs(i, preCourses, isVisited)) {
                    return new int[0];
                }
            } else if (isVisited[i] == 1) {
                return new int[0];
            }
        }

        return courseOrder.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean dfs(int root, List<Integer>[] preCourses, int[] isVisited) {
        //当前结点正在搜索中
        isVisited[root] = 1;
        //当前结点的下一个结点
        List<Integer> nexts = preCourses[root];
        for (int i = 0; i < nexts.size(); i++) {
            int next = nexts.get(i);
            if (isVisited[next] == 1) {
                //说明形成了环
                return false;
            } else if (isVisited[next] == 0) {
                //下一个结点未搜索 则 dfs
                if (!dfs(next, preCourses, isVisited)) {
                    return false;
                }
            }
        }
        //所有的next结点都搜索完成
        isVisited[root] = 2;
        //并把当前结点放入队列
        courseOrder.add(root);
        return true;
    }
}
