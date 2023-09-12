package com.zzc.leetcode_sep;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-11 19:39
 */
public class ScheduleCourse {
    public static void main(String[] args) {
        //int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        int[][] courses = {{7,17},{3,12},{10,20},{9,10},{5,20},{10,19},{4,18}};
        System.out.println(scheduleCourse(courses));
    }
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b)-> {
            if (b[1] == a[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int current = 0;
        int res = 0;
        //大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b - a);
        for (int i = 0; i < courses.length; i++) {
            int[] currentCourse = courses[i];
            int needTime = currentCourse[0];
            int deadLine = currentCourse[1];
            if (current + needTime <= deadLine) {
                //将当前课程用时放入大顶堆
                pq.offer(needTime);
                current += needTime;
                res++;
            }else {
                //比较当前用时 与 大顶堆中最大用时
                if (!pq.isEmpty()){
                    int maxTime = pq.peek();
                    if (maxTime > needTime) {
                        //不学 maxTime 的课程，而学习当前课程
                        //res不变
                        current = current - (maxTime - needTime);
                        pq.poll();
                        pq.offer(needTime);
                    }
                }

            }
        }

        return res;
    }
}
