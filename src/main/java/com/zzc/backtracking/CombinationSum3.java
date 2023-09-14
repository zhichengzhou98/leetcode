package com.zzc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-14 20:29
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 cs = new CombinationSum3();
        System.out.println(cs.combinationSum3(2, 3));
    }

    List<List<Integer>> res;
    int used;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        used = k;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }
        dfs(n, new ArrayList<>(), list, 0);
        return res;
    }

    public void dfs(int target, List<Integer> singleRes, List<Integer> left, int begin) {
        if (left.size() == (9 - used)) {
            if (target == 0) {
                res.add(new ArrayList<>(singleRes));
            }
            return;
        }
        for (int i = begin; i < left.size(); i++) {
            int current = left.get(i);
            if (current > target) {
                return;
            }else {
                singleRes.add(current);
                List<Integer> copy = new ArrayList<>(left);
                copy.remove(i);
                //递归
                dfs(target - current, singleRes, copy, i);
                //回溯
                singleRes.remove(singleRes.size()-1);
            }
        }

    }
}
