package com.zzc.leetcode_mar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-03-21 22:37
 */
public class FrequencyTracker {

    @Test
    public void test() {
        FrequencyTracker tracker = new FrequencyTracker();
        tracker.add(3);
        tracker.deleteOne(3);
        System.out.println(cntNumMap);
        System.out.println(tracker.hasFrequency(1));
    }

    Map<Integer, Integer> numCntMap;

    Map<Integer, Set<Integer>> cntNumMap;
    public FrequencyTracker() {
        numCntMap = new HashMap<>();
        cntNumMap = new HashMap<>();
    }

    public void add(int number) {
        int beforeFrequency = numCntMap.getOrDefault(number, 0);
        int nowFrequency = beforeFrequency + 1;
        numCntMap.put(number, nowFrequency);
        Set<Integer> integers = cntNumMap.get(beforeFrequency);
        if (integers!= null && !integers.isEmpty()) {
            integers.remove(number);
            if (integers.isEmpty()) {
                cntNumMap.remove(beforeFrequency);
            }
        }
        if (cntNumMap.containsKey(nowFrequency)) {
            cntNumMap.get(nowFrequency).add(number);
        }else {
            Set<Integer> set = new HashSet<>();
            set.add(number);
            cntNumMap.put(nowFrequency, set);
        }
    }

    public void deleteOne(int number) {
        if (numCntMap.containsKey(number)) {
            int beforeFrequency = numCntMap.get(number);
            int nowFrequency = beforeFrequency - 1;
            if (nowFrequency!=0) {
                numCntMap.put(number, nowFrequency);
            }else {
                numCntMap.remove(number);
            }
            Set<Integer> integers = cntNumMap.get(beforeFrequency);
            if (integers!= null && !integers.isEmpty()) {
                integers.remove(number);
                if (integers.isEmpty()) {
                    cntNumMap.remove(beforeFrequency);
                }
            }
            if (cntNumMap.containsKey(nowFrequency)) {
                cntNumMap.get(nowFrequency).add(number);
            }else if (nowFrequency != 0) {
                Set<Integer> set = new HashSet<>();
                set.add(number);
                cntNumMap.put(nowFrequency, set);
            }
        }
    }

    public boolean hasFrequency(int frequency) {
        return cntNumMap.containsKey(frequency);
    }

}
