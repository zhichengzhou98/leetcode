package com.zzc.template;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 拓扑排序， 判断有向图是否有环
 * @create 2023-09-09 12:52
 */
public class TopSort {
    //prerequisites所有边的集合
    public boolean topSort(int numCourses, int[][] prerequisites) {
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
            //未搜索的结点
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
}
