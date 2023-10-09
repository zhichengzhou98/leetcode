package com.zzc.weekcompetition;

import java.util.Comparator;
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
        tasks.sort(Comparator.comparingInt(x -> -x));
        int minTime = Integer.MIN_VALUE;
        for (int i = 0; i < processorTime.size(); i++) {
            Integer processor = processorTime.get(i);
            Integer task = tasks.get(4 * i);
            minTime = Math.max(minTime, processor + task);
        }
        return minTime;
    }
}
