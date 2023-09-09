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
        //int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};
        //int[][] prerequisites = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        int[][] prerequisites = {{0, 0}};
        //int[][] prerequisites = {{0,1},{3,1},{1,3},{3,2}};
        //int[][] prerequisites = {{1, 0}, {2, 1}};
        System.out.println(can.canFinish(1, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] grids = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            grids[i] = new ArrayList<>();
        }

        for(int[] edge : prerequisites) {
            grids[edge[0]].add(edge[1]);
        }
        //0：未搜索  1：搜索中 2：已完成
        int[] isVisited = new int[numCourses];
        //从每个根节点开始dfs
        for (int i = 0; i < isVisited.length; i++) {
            //从未搜索的结点开始
            if (isVisited[i] == 0) {
                boolean res = dfs(i, isVisited, grids);
                if (!res){
                    return false;
                }
            }else if (isVisited[i] == 1) {
                return false;
            }
        }
        return true;
    }

    //grid[i]（List<Integer>） 当前结点的下一个结点的集合
    //isVisited：0 未搜索； 1 搜索中； 2 已搜索
    public boolean dfs(int root, int[] isVisited, List<Integer>[] grid) {
        //当前结点正在搜索中
        isVisited[root] = 1;
        //所有的下一个结点
        List<Integer> nexts =  grid[root];
        for (int i = 0; i < nexts.size(); i++) {
            int nextNode = nexts.get(i);
            if (isVisited[nextNode] == 1) {
                //下一个结点在搜索中，说明形成了环
                return false;
            }else if (isVisited[nextNode] == 0) {
                //下一个结点未被搜索
                if (!dfs(nextNode, isVisited, grid)) {
                    return false;
                }
            }
        }
        isVisited[root] = 2;
        return true;
    }
    /*public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] grids = new int[numCourses][numCourses];
        for(int[] edge : prerequisites) {
            if (edge[0] != edge[1]) {
                grids[edge[0]][edge[1]] = 1;
            }else {
                return false;
            }
        }

        //0：未搜索  1：搜索中 2：已完成
        int[] isVisited = new int[numCourses];
        //从每个根节点开始dfs
        for (int i = 0; i < isVisited.length; i++) {
            //从未搜索的结点开始
            if (isVisited[i] == 0) {
                boolean res = dfs(i, isVisited, grids);
                if (!res){
                    return false;
                }
            }else if (isVisited[i] == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int root, int[] isVisited, int[][] grid) {
        //当前结点正在搜索中
        isVisited[root] = 1;
        //可能的下一个结点
        List<Integer> nexts = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            if (grid[root][i] == 1) {
                //是下个结点
                if (isVisited[i] == 0) {
                    nexts.add(i);
                }else if (isVisited[i] == 1){
                    //下一个结点在搜索中，说明形成了环
                    return false;
                }
            }
        }
        for (int i = 0; i < nexts.size(); i++) {
            int nextNode = nexts.get(i);
            if (!dfs(nextNode, isVisited, grid)) {
                return false;
            }
        }
        isVisited[root] = 2;
        return true;
    }*/
}
