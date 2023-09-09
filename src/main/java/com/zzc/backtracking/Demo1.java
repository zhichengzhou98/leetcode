package com.zzc.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zzc
 * @Description
 * @create 2022-12-18 21:02
 */
public class Demo1 {
    public static void main(String[] args) {



        List<List<Integer>> lists = combinationSum(new int[]{2,3,6,7}, 7);
        for (List<Integer> list : lists) {
            int[] ints = list.stream().mapToInt(i -> i).toArray();
            System.out.println(Arrays.toString(ints));
        }

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //先对候选数组进行排序
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates,path,target,0,0,res);
        return res;
    }

    /**
     *
     * @param candidates 候选数组
     * @param path 从根到叶子节点的路径
     * @param target 目标值
     * @param begin 搜索的起点
     * @param sum 路径之和
     * @param res 最终结果
     */
    public static void  dfs(int[] candidates,List<Integer> path,int target,int begin,int sum,List<List<Integer>> res){
        //路径之和刚好等于目标结果
        if(sum == target){
            //这里必须new一个链表  不然直接加入path  path后续变化 会影响到res的结果
            res.add(new ArrayList<>(path));
            return;
        }
        //路径之和大于结果 不能继续递归 也不能回溯（回溯后的路径之和比sum更大）
        if(sum > target){
            return;
        }
        //路径之和小于结果
        //从候选数组的begin开始继续递归
        for (int i = begin; i < candidates.length; i++) {
            if(sum + candidates[i] > target){
                //直接退出循环  不需要再递归后面的
                break;
            }
            path.add(candidates[i]);
            dfs(candidates,path,target,i,sum + candidates[i],res);
            path.remove(path.size()-1);
        }
    }



}
