package com.zzc.weekcompetition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-16 23:09
 */
public class CountPairs {
    public static void main(String[] args) {
        List<List<Integer>> coordinates = new ArrayList<>();
        List<Integer> arr1 = List.of(1,3);
        List<Integer> arr2 = List.of(1,3);
        List<Integer> arr3 = List.of(1,3);
        List<Integer> arr4 = List.of(1,3);
        List<Integer> arr5 = List.of(1,3);
        coordinates.add(arr1);
        coordinates.add(arr2);
        coordinates.add(arr3);
        coordinates.add(arr4);
        coordinates.add(arr5);
        CountPairs cp = new CountPairs();
        System.out.println(cp.countPairs(coordinates, 0));
    }
    public int countPairs(List<List<Integer>> coordinates, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < coordinates.size(); i++) {
            List<Integer> listI = coordinates.get(i);
            int xI = listI.get(0);
            int yI = listI.get(1);

            for (int j = 0; j <= k ; j++) {
                int xJ = xI ^ j;
                int yJ = yI ^ (k - j);
                sum += map.getOrDefault(xJ +";" + yJ, 0);
            }
            String key = xI +";"+ yI;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return sum;
    }

    public boolean check(List<Integer> list0, List<Integer> list1, int k) {
        int ix = list0.get(0);
        int iy = list0.get(1);
        int jx = list1.get(0);
        int jy = list1.get(1);
        if ((ix ^ jx) + (iy ^ jy) == k) {
           return true;
        }
        return false;
    }
    /*public int countPairs(List<List<Integer>> coordinates, int k) {
        int res = 0;
        for (int i = 0; i < coordinates.size() - 1; i++) {
            List<Integer> listI = coordinates.get(i);
            int ix = listI.get(0);
            int iy = listI.get(1);
            for (int j = i + 1; j < coordinates.size(); j++) {
                List<Integer> listJ = coordinates.get(j);
                int jx = listJ.get(0);
                int jy = listJ.get(1);
                if ((ix ^ jx) + (iy ^ jy) == k) {
                    res++;
                }
            }
        }
        return res;
    }*/
}
