package com.zzc.exam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zzc
 * @Description
 * @create 2022-12-13 23:01
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tarStr = scanner.nextLine();
        int target = Integer.parseInt(tarStr);//目标
        String s = scanner.nextLine();
        String substring = s.substring(1, s.length() - 1);
        String[] split = substring.split(", ");
        int[] candidates = new int[split.length];//候选数组
        for (int i = 0;i < candidates.length;i++){
            candidates[i] = Integer.parseInt(split[i]);
        }
        List<List<Integer>> zuhe = zuhe(candidates, target);
        System.out.println(zuhe);


    }
    public static  List<List<Integer>>  zuhe(int[] candidates,int target){
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        dfs(candidates,0,len,target,deque,res);
        return res;
    }

    private static void dfs(int[] candidates, int start, int len, int target, ArrayDeque<Integer> deque, List<List<Integer>> res) {
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = start;i < len;i++){
            deque.addLast(candidates[i]);
            dfs(candidates,i,len,target-candidates[i],deque,res);
            deque.removeLast();
        }

    }

}
