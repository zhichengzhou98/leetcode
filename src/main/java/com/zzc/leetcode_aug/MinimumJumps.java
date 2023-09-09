package com.zzc.leetcode_aug;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-30 12:07
 */
public class MinimumJumps {
    public static void main(String[] args) {
        MinimumJumps jumps = new MinimumJumps();
        System.out.println(jumps.minimumJumps(new int[]{
                162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73,
                200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54,
                154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177,
                82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136,
                72, 98}, 29, 98, 80));
    }




    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int lower = 0;
        int upper = Math.max(Arrays.stream(forbidden).max().getAsInt() + a, x) + b;

        Set<Integer> set = Arrays.stream(forbidden).boxed().collect(Collectors.toSet());
        Set<Integer> reached = new HashSet<>();
        List<int[]> list = new ArrayList<>();
        //数组中保存当前坐标 方向（a or -b） 移动次数
        list.add(new int[]{0, a, 0});
        //当前位置已到达
        reached.add(0);
        while (!list.isEmpty()) {
            //当前操作
            int[] remove = list.remove(0);
            int currentPos = remove[0];
            int dir = remove[1];
            int cnt = remove[2];
            if (currentPos == x) {
                //到达终点
                return cnt;
            }


            int next = currentPos + a;
            cnt++;
            //TODO 并且未超右边界
            if (!set.contains(next) && !reached.contains(next) && next >= lower && next <= upper) {
                //将点加入队列就说明要访问该点！！！应该在此时将该点设置为visited
                list.add(new int[]{next, a, cnt});
                reached.add(next);
            }
            //未到终点
            if (dir > 0) {
                //不能再向后移动
                //下次坐标
                next = currentPos - b;
                if (!set.contains(next) && !reached.contains(-next) && next >= lower && next <= upper) {
                    list.add(new int[]{next, -b, cnt});
                    reached.add(-next);
                }

            }
        }
        return -1;
    }


    //flag true表示上一次是往后
    //贪心 ×
    /*public void jump(Set<Integer> forbidden, int a, int b, int start, int end, boolean flag) {
        if (start == end) {
            //到达目的地
            return;
        }
        if (flag) {
            if(start >end) {
                cnt = -1;
                return;
            }
            //只能往前
            int next = start + a;
            if (forbidden.contains(next)) {
                //无法到达
                cnt = -1;
                return;
            }
            cnt++;
            forbidden.add(next);
            //以next为起点继续
            jump(forbidden, a, b, next, end, false);
        }else {
            if (start < end) {
                //优先向前跳
                int next = start + a;
                if (forbidden.contains(next)) {
                    //向后跳
                    next = start - b;
                    if (next <= 0 || forbidden.contains(next)) {
                        //无法到达
                        cnt = -1;
                        return;
                    }else {
                        cnt++;
                        forbidden.add(next);
                        //以next为起点继续
                        jump(forbidden, a, b, next, end, true);
                    }
                }else {
                    cnt++;
                    forbidden.add(next);
                    //以next为起点继续
                    jump(forbidden, a, b, next, end, false);
                }
            }else {
                //优先向后跳
                int next = start - b;
                if (next <= 0 ||forbidden.contains(next)) {
                    //向前跳
                    next = start + a;
                    if (forbidden.contains(next)) {
                        //无法到达
                        cnt = -1;
                        return;
                    }else {
                        cnt++;
                        forbidden.add(next);
                        //以next为起点继续
                        jump(forbidden, a, b, next, end, false);
                    }
                }else {
                    cnt++;
                    forbidden.add(next);
                    //以next为起点继续
                    jump(forbidden, a, b, next, end, true);
                }

            }
        }

    }*/

}
