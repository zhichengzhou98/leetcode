package com.zzc.leetcode_sep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-12 10:12
 */
public class CheckIfPrerequisite {
    public static void main(String[] args) {
        CheckIfPrerequisite cIP = new CheckIfPrerequisite();
        int[][] prerequisites = {{4,3},{4,1},{4,0},{3,2},{3,1},{3,0},{2,1},{2,0},{1,0}};
        int[][] queries = {{4,2}};
        System.out.println(cIP.checkIfPrerequisite(5,prerequisites, queries));
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // numCourses 课程名：[0, n-1]
        // 当前课程的所有前驱结点
        Set<Integer>[] precursorNodes = new HashSet[numCourses];
        //当前结点直接相连的前驱
        List<Integer>[] directPrecursor = new List[numCourses];
        for (int i = 0; i < precursorNodes.length; i++) {
            precursorNodes[i] = new HashSet<>();
            directPrecursor[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] current = prerequisites[i];
            directPrecursor[current[0]].add(current[1]);
        }

        //节点是否访问 0：未访问；1：访问中；2：已遍历
        int[] isVisited = new int[numCourses];
        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i] == 0) {
               dfs(isVisited, i, directPrecursor, precursorNodes);
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int first = query[0];
            int next = query[1];
            Set<Integer> set = precursorNodes[first];
            if (!set.isEmpty() && set.contains(next)) {
                res.add(true);
            }else {
                res.add(false);
            }
        }
        return res;
    }

    public Set<Integer> dfs(int[] isVisited, int currentCourse, List<Integer>[] directPrecursor, Set<Integer>[] precursorNodes) {
        isVisited[currentCourse] = 1;
        //当前结点的直接前驱
        List<Integer> nexts = directPrecursor[currentCourse];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nexts.size(); i++) {
            set.add(nexts.get(i));
            if (isVisited[nexts.get(i)] == 0) {
                set.addAll(dfs(isVisited, nexts.get(i), directPrecursor, precursorNodes));
            }else {
                set.addAll(precursorNodes[nexts.get(i)]);
            }
        }
        precursorNodes[currentCourse] = set;
        isVisited[currentCourse] = 2;
        return set;
    }
}
