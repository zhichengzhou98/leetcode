package com.zzc.leetcode_aug;

import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-27 10:04
 */
public class Merge {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[][]{{4,5},{2,4},{4,6},{3,4},{0,0},{1,1},{3,5},{2,2}})));
        //System.out.println(Arrays.toString(merge(new int[][]{{0,6},{0,0}})));
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        int j = i + 1;
        List<int[]> list = new ArrayList<>();
        if (j >= intervals.length) {
            list.add(intervals[i]);
        }
        while (j < intervals.length) {
            int[] des = intervals[i];
            while (j < intervals.length) {
                int[] arr = intervals[j];
                if (arr[0] <= des[1]) {
                    des[1] = Math.max(des[1], arr[1]);
                    j++;
                }else  {
                    list.add(des);
                    i = j;
                    j++;
                    break;
                }

            }
            if (j >= intervals.length) {
                list.add(intervals[i]);
                break;
            }
        }
        int[][] res = new int[list.size()][];
        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(k);
        }
        return res;
    }
    /*public static int[][] merge(int[][] intervals) {
        int[] xAxis = new int[10001];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < intervals.length; i++) {
            //
            //1 表示起点 -1表示终点 2 表示起点和终点
            //起点++ 终点--
            int start = intervals[i][0];
            int end = intervals[i][1];
            xAxis[start]++;
            xAxis[end]--;
            if (start == end) {
                set.add(start);
            }else {
                set.remove(start);
                set.remove(end);
            }
        }
        for (int i = 0; i < intervals.length; i++) {
            //
            //1 表示起点 -1表示终点 2 表示起点和终点
            //起点++ 终点--
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start != end) {
                set.remove(start);
                set.remove(end);
            }
        }
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < xAxis.length) {
            while (i < xAxis.length && xAxis[i] <= 0 ) {
                i++;
            }
            if (i >= xAxis.length) {
                break;
            }
            // i 是第一个起点
            int[] array = new int[2];
            array[0] = i;
            int j = i + 1;
            int startCount = xAxis[i];
            while (j < xAxis.length) {
                while (j < xAxis.length && (xAxis[j] == 0) ) {
                    set.remove(j);
                    j++;

                }
                if (j >= xAxis.length) {
                    break;
                }
                if (xAxis[j] < 0) {
                    //终点
                    startCount += xAxis[j];
                    if (startCount == 0) {
                        array[1] = j;
                        res.add(array);
                        break;
                    }
                }else if(xAxis[j] > 0){
                    //j是起点
                    startCount += xAxis[j];
                }
                j++;
            }
            if (j >= xAxis.length) {
                break;
            }
            i = j + 1;
        }
        if (set.size() == 0) {
            int[][] result = new int[res.size()][];

            for (int j = 0; j < result.length; j++) {
                result[j] = res.get(j);
            }

            return result;
        }
        int[] array = set.stream().mapToInt(Integer::intValue).toArray();
        int[][] result = new int[res.size() + set.size()][];
        int j = 0;
        for (; j < res.size(); j++) {
            result[j] = res.get(j);
        }

        for (int k = j; k < result.length; k++) {
            result[k] = new int[]{array[k - j], array[k - j]};
        }
        return result;
    }*/
}
