package com.zzc.leetcode_aug;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-30 21:32
 */
public class RecentCounter {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
    }
    List<Integer> time;
    public RecentCounter() {
        time = new ArrayList<>();
    }

    public int ping(int t) {
        time.add(t);
        while (!time.isEmpty()) {
            int lastTime = time.get(0);
            if (lastTime < t - 3000) {
                time.remove(0);
            }else {
                break;
            }
        }

        return time.size();
    }
}
