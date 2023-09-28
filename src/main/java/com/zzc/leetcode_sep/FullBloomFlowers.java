package com.zzc.leetcode_sep;

import com.zzc.utils.ArrayUtils;

import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-28 12:21
 */
public class FullBloomFlowers {
    public static void main(String[] args) throws Exception {
        int[][] f = ArrayUtils.generate("array", int[][].class);
        int[] p = ArrayUtils.generate("array1", int[].class);
        FullBloomFlowers fBF = new FullBloomFlowers();
        System.out.println(Arrays.toString(fBF.fullBloomFlowers(f, p)));
    }
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        // 使用treemap
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < flowers.length; i++) {
            int next = flowers[i][1];
            next++;
            map.put(flowers[i][0],map.getOrDefault(flowers[i][0], 0) + 1);
            map.put(next, map.getOrDefault(next, 0)-1);
        }
        int firstKey = map.firstKey();
        int lastElement = 0;
        //0 为时间， 1 为数量
        List<int[]> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            Integer key = e.getKey();
            Integer value = e.getValue();
            lastElement = lastElement + value;
            list.add(new int[]{key, lastElement});
        }
        int[] res1 = new int[people.length];
        for (int i = 0; i < res1.length; i++) {
            if (people[i] < firstKey) {
                res1[i] = 0;
            }else {
                //查找右边界
                res1[i] = binarySearch(list, people[i]);
            }
        }
        return res1;
    }

    public int binarySearch(List<int[]> list, int target){
        int l = 0;
        int r = list.size() - 1;
        int med = (r - l + 1 )/ 2 + l;
        while (l < r) {
            //不超过target的最大值
            if (checkMedRight(list.get(med)[0], target)) {
                l = med;
            }else {
                r = med - 1;
            }
            med = (r - l + 1 ) / 2 + l;
        }
        return list.get(med)[1];
    }

    public boolean checkMedRight(int med, int target) {
        if(med <= target) {
            return true;
        }
        return false;
    }

    /*public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < flowers.length; i++) {
            maxTime = Math.max(maxTime, flowers[i][1]);
        }
        int[] diff = new int[maxTime + 2];
        for (int i = 0; i < flowers.length; i++) {
            int next = flowers[i][1];
            next++;
            diff[flowers[i][0]]++;
            diff[next]--;
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] = diff[i - 1] + diff[i];
        }
        int[] res = new int[people.length];
        for (int i = 0; i < res.length; i++) {
            if (people[i] >= diff.length) {
                res[i] = 0;
            }else {
                res[i] = diff[people[i]];
            }
        }
        return res;
    }*/
}
