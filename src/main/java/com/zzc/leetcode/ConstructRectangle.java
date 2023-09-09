package com.zzc.leetcode;


/*作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 所以，现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：

你设计的矩形页面必须等于给定的目标面积。
宽度 W不应大于长度 L ，换言之，要求 L >= W 。
长度 L 和宽度 W之间的差距应当尽可能小。
返回一个数组[L, W]，其中 L 和 W 是你按照顺序设计的网页的长度和宽度。
*/

import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-09 13:18
 */
public class ConstructRectangle {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructRectangle(122122)));
    }

   /* public static int[] constructRectangle(int area) {
        int l = (int) Math.sqrt(area);
        int w = (int) area / l;
        while (true) {
            if(l * w == area && l >= w){
                return new int[]{l, w};
            }
            l++;
            w = (int) area / l;
        }
    }*/

    public static int[] constructRectangle(int area) {
        int l = (int) Math.sqrt(area);
        int w = (int) area / l;
        while (l * w != area) {
            if (l * w < area) {
                l++;
            } else {
                w--;
            }
        }
        return new int[]{l, w};
    }
}


