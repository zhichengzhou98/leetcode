package com.zzc.leetcode_feb;

import com.zzc.utils.ArrayUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-02-06 10:52
 */
public class MagicTower {

    @Test
    public void test() {
        try {
            int[] arr = ArrayUtils.generate("array1", int[].class);
            //System.out.println(magicTower(new int[]{5,-4,1,-2,-2,-2,4}));
            System.out.println(magicTower(arr));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public int magicTower(int[] nums) {
        int sum = Arrays.stream(nums).sum() + 1;
        if (sum <= 0) {
            return -1;
        }
        int cnt = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long currentVal = 1;
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i];
            currentVal += diff;
            if (diff < 0) {
                queue.offer(diff);
                //扣血
                if (currentVal <= 0) {
                    currentVal = currentVal - queue.poll();
                    cnt++;
                }
            }
        }
        return cnt;
    }
    /*public int magicTower(int[] nums) {
        int sum = Arrays.stream(nums).sum() + 1;
        if (sum <= 0) {
            return -1;
        }
        int cnt = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long currentVal = 1;
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i];
            if (diff >= 0) {
                currentVal += diff;
            }else {
                //扣血
                if (currentVal + diff > 0) {
                    currentVal += diff;
                    queue.offer(diff);
                }else {
                    queue.offer(diff);
                    Integer poll = queue.poll();
                    currentVal = currentVal - poll + diff;
                    cnt++;
                }
            }
        }
        return cnt;
    }*/
}
