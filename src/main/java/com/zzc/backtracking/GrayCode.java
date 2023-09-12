package com.zzc.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-10 20:18
 */
public class GrayCode {
    public static void main(String[] args) {
        /*int[] s = new int[65535];
        System.out.println(Math.pow(2, 16));*/
        GrayCode gc = new GrayCode();
        System.out.println(gc.grayCode(16));
        //System.out.println(gc.checkNums(5,3));
    }
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i);
        }
        return ret;
    }

    /*List<Integer> ans = new ArrayList<>();
    int limit;
    boolean flag = false;
    int[] map;
    int n;
    public List<Integer> grayCode(int n) {
        this.n = n;
        limit = (int) Math.pow(2, n);
        map = new int[limit];
        map[0] = 1;
        ans.add(0);
        backtrack(0);
        return ans;
    }
    private void backtrack(int current) {
        if (ans.size() == limit) {
            if (Integer.bitCount(current) == 1) flag = true;
            return;
        }
        for (int i = 0; i < n; i++) {
            int next = current ^ (1 << i);
            if (map[next] == 0) {
                map[next] = 1;
                ans.add(next);
                backtrack(next);
                //找到一组就提前退出！！！
                if (flag) return;
                map[next] = 0;
                ans.remove((Integer) next);
            }
        }
    }*/

}
