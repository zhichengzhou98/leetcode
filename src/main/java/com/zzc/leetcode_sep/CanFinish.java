package com.zzc.leetcode_sep;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 207. 课程表
 * @create 2023-09-09 8:10
 */
public class CanFinish {
    //判断有向图是否有环
    //如果整个数据构成一个环，则不存在可能的根节点， 所以应该遍历所有结点
    /*public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] grids = new int[numCourses][numCourses];
        for(int[] edge : prerequisites) {
            grids[edge[0]][edge[1]] = 1;
        }
        //找到根节点，可能有多个
        List<Integer> roots = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            while (j < numCourses && grids[i][j] != 1) {
                j++;
            }
            if (j == numCourses) {
                roots.add(i);
            }
        }
        //从每个根节点开始dfs
        for (Integer root : roots) {
            boolean[] isVisited = new boolean[numCourses];
            boolean res = dfs(root, isVisited, grids);
            if (!res){
                return false;
            }
        }

        return true;
    }*/

    public static void main(String[] args) {
        CanFinish can = new CanFinish();
        //int[][] prerequisites = {{1, 0}, {0, 1}};
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};
        //int[][] prerequisites = {{1, 0}};
        System.out.println(can.canFinish(5, prerequisites));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] grids = new int[numCourses][numCourses];
        for(int[] edge : prerequisites) {
            grids[edge[0]][edge[1]] = 1;
        }
        List<Integer> roots = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            while (j < numCourses && grids[j][i] != 1) {
                j++;
            }
            if (j == numCourses) {
                roots.add(i);
            }
        }
        if (roots.isEmpty()) {
            return false;
        }


        boolean[] isVisited = new boolean[numCourses];
        //从每个根节点开始dfs
        for (int root = 0; root < roots.size() && !isVisited[roots.get(root)]; root++) {
            isVisited[roots.get(root)] = true;
            boolean res = dfs(roots.get(root), isVisited, grids);
            if (!res){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int root, boolean[] isVisited, int[][] grid) {
        //可能的下一个结点
        List<Integer> nexts = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            if (grid[root][i] == 1) {
                //是下个结点
                if (isVisited[i]) {
                    return false;
                }
                nexts.add(i);
                isVisited[i] = true;
                if (!dfs(i, isVisited, grid)) {
                    return false;
                }
                isVisited[i] = false;
            }
        }
        return true;
    }
}
