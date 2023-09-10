package com.zzc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description LCR 084. 全排列 II
 * @create 2023-09-10 17:19
 */
public class PermuteUnique {
    public static void main(String[] args) {

    }


    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(Arrays.stream(nums).boxed().collect(Collectors.toList()), new ArrayList<>());
        return res;
    }

    public void dfs(List<Integer> nums, List<Integer> path) {
        if (nums.isEmpty()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (i >= 1 && nums.get(i).intValue() == nums.get(i-1).intValue()) {
                //重复元素跳过
                continue;
            }
            List<Integer> copy = new ArrayList<>(nums);
            Integer remove = copy.remove(i);
            path.add(remove);
            dfs(copy, path);
            //回溯
            path.remove(path.size()- 1);
        }
    }
}
