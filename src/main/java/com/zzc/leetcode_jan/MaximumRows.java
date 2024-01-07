package com.zzc.leetcode_jan;

import com.zzc.utils.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description //TODO: 2024.01.04
 * @create 2024-01-04 12:17
 */
public class MaximumRows {
    @Test
    public void test() {
        try {
            int[][] arr =  ArrayUtils.generate("array2", int[][].class);
            System.out.println(maximumRows(arr, 2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int maximumRows(int[][] matrix, int numSelect) {
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    set.add(j);
                }
            }
            list.add(set);
        }
        int zeroRows = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() == 0) {
                zeroRows++;
            }
        }
        int line = matrix[0].length;
        List<int[]> cntsIndexList = new ArrayList<>();
        List<Set<Integer>> usefulList = list.stream().filter(set -> set.size() <= numSelect && set.size() > 0).collect(Collectors.toList());
        for (int i = 0; i < line; i++) {
            int cnt = 0;
            for (int j = 0; j < usefulList.size(); j++) {
                Set<Integer> set = usefulList.get(j);
                if (set.contains(i)) {
                    cnt++;
                }
            }
            cntsIndexList.add(new int[]{cnt, i});
        }
        if (numSelect >= cntsIndexList.size()) {
            return usefulList.size() + zeroRows;
        }
        cntsIndexList.sort((a, b) -> b[0] - a[0]);
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < numSelect; i++) {
            res.add(cntsIndexList.get(i)[1]);
        }
        long count = usefulList.stream().filter(set -> res.containsAll(set)).count();
        return (int) count + zeroRows;
    }
}
