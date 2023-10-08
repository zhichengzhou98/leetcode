package com.zzc.weekcompetition;

import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-08 10:36
 */
public class MinProcessingTime {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        //升序
        processorTime.sort(Integer::compareTo);
        //降序
        tasks.sort((a, b)-> b- a);
        int j = 0;
        int minTime = Integer.MIN_VALUE;
        for (int i = 0; i < processorTime.size(); i++) {
            Integer integer = processorTime.get(i);
            Integer integer1 = tasks.get(4 * i);
            minTime = Math.max(minTime, integer + integer1);
        }
        return minTime;
    }
}
