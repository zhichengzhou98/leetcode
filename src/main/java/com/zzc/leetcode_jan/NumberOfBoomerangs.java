package com.zzc.leetcode_jan;

import com.zzc.utils.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-01-08 12:10
 */
public class NumberOfBoomerangs {
    @Test
    public void test() throws IOException {
        int[][] points = ArrayUtils.generate("array2", int[][].class);
        System.out.println(numberOfBoomerangs(points));
    }
    public int numberOfBoomerangs(int[][] points) {
        int[][] dirs = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        Set<String> pointSets = new HashSet<>();
        for(int[] point : points) {
            pointSets.add(point[0] +","+ point[1]);
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int[] pointI = points[i];
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                int[] pointJ = points[j];
                int deltX = Math.abs(pointJ[0] - pointI[0]);
                int deltY = Math.abs(pointJ[1] - pointI[1]);
                Set<String> tempSet = new HashSet<>();
                for (int k = 0; k < dirs.length; k++) {
                    int desX = deltX * dirs[k][0] + pointI[0];
                    int desY = deltY * dirs[k][1] + pointI[1];
                    tempSet.add(desX + "," + desY);
                    desX = deltY * dirs[k][1] + pointI[0];
                    desY = deltX * dirs[k][0] + pointI[1];
                    tempSet.add(desX + "," + desY);
                }
                List<String> list = tempSet.stream()
                        .filter(item -> !item.equals(pointJ[0] + "," + pointJ[1])
                        && !item.equals(pointI[0] + "," + pointI[1]))
                        .collect(Collectors.toList());
                for (int k = 0; k < list.size(); k++) {
                    if (pointSets.contains(list.get(k))) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public int numberOfBoomerangs1(int[][] points) {
        int[][] dirs = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        Set<Integer> pointSets = new HashSet<>();
        for(int[] point : points) {
            pointSets.add(point[0] * (10001)  + point[1]);
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int[] pointI = points[i];
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                int[] pointJ = points[j];
                int deltX = Math.abs(pointJ[0] - pointI[0]);
                int deltY = Math.abs(pointJ[1] - pointI[1]);
                Set<Integer> tempSet = new HashSet<>();
                for (int k = 0; k < dirs.length; k++) {
                    int desX = deltX * dirs[k][0] + pointI[0];
                    int desY = deltY * dirs[k][1] + pointI[1];
                    tempSet.add(desX * (10001)  + desY);
                    desX = deltY * dirs[k][1] + pointI[0];
                    desY = deltX * dirs[k][0] + pointI[1];
                    tempSet.add(desX * (10001)  + desY);
                }
                List<Integer> list = tempSet.stream()
                        .filter(item -> item != (pointJ[0] * (10001)  + pointJ[1])
                                && item != (pointI[0] * (10001)  + pointI[1]))
                        .collect(Collectors.toList());
                for (int k = 0; k < list.size(); k++) {
                    if (pointSets.contains(list.get(k))) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
