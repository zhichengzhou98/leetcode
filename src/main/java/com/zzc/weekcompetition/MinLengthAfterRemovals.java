package com.zzc.weekcompetition;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-16 22:42
 */
public class MinLengthAfterRemovals {
    public static void main(String[] args) {
        System.out.println(minLengthAfterRemovals(List.of(2, 3, 4)));
    }

    public static int minLengthAfterRemovals(List<Integer> nums) {
        //统计每个数出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //把次数放入优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->b - a);
        for(Integer value: map.values()) {
            queue.offer(value);
        }
        if (queue.size() == 1) {
            return queue.poll();
        }
        while (queue.size() > 1) {
            int max = queue.poll();
            int min = queue.poll();
            if (max - 1 != 0) {
                queue.offer(max- 1);
            }
            if (min - 1 != 0) {
                queue.offer(min- 1);
            }
        }
        if (queue.size() == 1) {
            return queue.poll();
        }
        return 0;
    }
}
