package com.zzc.binarySearch;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zc.zhou
 * @Description TODO 直接使用优先队列
 * @create 2023-09-20 20:27
 */
public class FurthestBuilding {
    public static void main(String[] args) {

    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int l = 0;
        int r = heights.length - 1;
        //求右边界
        int med = (r - l + 1 )/ 2 + l;
        while (l < r) {
            if (checkMedRight(med, bricks, ladders, heights)) {
                l = med;
            }else {
                r = med - 1;
            }
            med = (r - l + 1 ) / 2 + l;
        }
        return med;
    }

    public boolean checkMedRight(int med, int bricks, int ladders, int[] heights) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b - a);
        Double diffHeight = 0D;
        for (int i = 1; i <= med; i++) {
            int current = heights[i];
            int pre = heights[i - 1];
            //当前的楼比前面的高
            if(current > pre) {
                diffHeight += current - pre;
                pq.offer(current - pre);
            }
        }
        if (ladders >= pq.size()) {
            return true;
        }
        while (ladders > 0) {
            Integer poll = pq.poll();
            diffHeight -= poll;
            if (bricks >= diffHeight) {
                return true;
            }
            ladders--;
        }
        return bricks >= diffHeight;
    }
}
