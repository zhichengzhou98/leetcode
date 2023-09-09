package com.zzc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zzc
 * @Description 全排列2
 * @create 2022-12-21 21:56
 */
public class Demo3 {
    static boolean[] visited;
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,path,res,0);
        return res;
    }

    public static void dfs(int[] nums,List<Integer> path,List<List<Integer>> res,int num){
       if(num == nums.length){
           res.add(new ArrayList<>(path));
           return;
       }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]||(i > 0 && nums[i]==nums[i-1]&&!visited[i-1])){
                //当前节点访问过则跳过当前节点
                //前一个节点遍历完之后(以前一个节点开头的所有结果都遍历完) 他的状态会改为false
                //此时继续遍历下一个节点 若下一个节点值与前一个节点值相同则跳过
                //因此判断条件为  !visited[i-1]  ，即前一个节点没有被访问过

                //例子 1(a)，1(b) ，
                //第一次遍历完是 1(a)，1(b)，然后将他们的访问状态都置为false 开始下一轮遍历
                //取出 1(b)，由于 1==1 并且前一次已经遍历过（从前往后遍历 要不然也不会出现1(b)开头的情况）
                //如果不加  !visited[i-1] ，那么只会遍历到 1(a)，当继续递归时，由于满足i > 0 && nums[i]==nums[i-1]
                //不再将 1(b)添加到结果中
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums,path,res,num+1);
            //回溯
            visited[i] = false;
            path.remove(num);
        }
    }
}
