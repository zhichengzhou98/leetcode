package com.zzc.leetcode_oct;

import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-13 12:03
 */
public class AvoidFlood {
    public static void main(String[] args) {
        AvoidFlood aF = new AvoidFlood();
        System.out.println(Arrays.toString(aF.avoidFlood(new int[]{1,0,2,3,0,1,2})));
    }
    public int findLeft(int target, List<Integer> index) {
        //查找 index > target 的最小index
        int l = 0;
        int r = index.size() - 1;
        int med = (r - l) / 2 + l;
        while (l < r) {
            if (index.get(med) > target) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return med;
    }
    public int[] avoidFlood(int[] rains) {
        //已经装满水的湖泊
        //key 为湖， value 为第 i 天
        Map<Integer, Integer> fulled = new HashMap<>();

        //可以抽水的索引
        ArrayList<Integer> dryIndex = new ArrayList<>();
        int[] res = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            //lake 湖泊会下雨
            int lake = rains[i];
            if (lake != 0) {
                // 判断 lake 是否装满水
                if (!fulled.isEmpty() && fulled.containsKey(lake)) {
                    Integer target = fulled.get(lake);
                    //装满水
                    if (dryIndex.isEmpty() || dryIndex.get(dryIndex.size() - 1) <= target) {
                        //无法抽水
                        return new int[0];
                    }
                    int indexOfList = findLeft(target, dryIndex);

                    Integer index = dryIndex.remove(indexOfList);
                    //第 index 天抽干lake
                    res[index] = lake;
                    res[i] = -1;
                    //更新 map
                    fulled.put(lake, i);
                }else {
                    // 没装满水
                    res[i] = -1;
                    fulled.put(lake, i);
                }
            }else {
                if (dryIndex.size() < fulled.size()) {
                    //先不选择抽水
                    dryIndex.add(i);
                }else {
                    res[i] = 1;
                }
            }
        }
        while (!dryIndex.isEmpty()) {
            Integer index = dryIndex.remove(0);
            res[index] = 1;
        }
        return res;
    }

    /*public int[] avoidFlood(int[] rains) {
        //已经装满水的湖泊
        Set<Integer> fulled = new HashSet<>();

        //可以抽水的索引
        Stack<Integer> dryIndex = new Stack<>();
        int[] res = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            //lake 湖泊会下雨
            int lake = rains[i];
            if (lake != 0) {
                // 判断 lake 是否装满水
                if (!fulled.isEmpty() && fulled.contains(lake)) {
                    //装满水
                    if (dryIndex.isEmpty()) {
                        //无法抽水
                        return new int[0];
                    }
                    Integer index = dryIndex.pop();
                    //第 index 天抽干lake
                    res[index] = lake;
                    res[i] = -1;
                    fulled.remove(lake);
                }else {
                    // 没装满水
                    res[i] = -1;
                    fulled.add(lake);
                }
            }else {
                if (dryIndex.size() < fulled.size()) {
                    //先不选择抽水
                    dryIndex.push(i);
                }else {
                    res[i] = 1;
                }
            }
        }
        while (!dryIndex.isEmpty()) {
            Integer index = dryIndex.pop();
            res[index] = 1;
        }
        return res;
    }*/
}
