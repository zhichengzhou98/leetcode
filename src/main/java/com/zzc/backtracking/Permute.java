package com.zzc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description LCR 083. 全排列
 * @create 2023-09-10 16:57
 */
public class Permute {
    public static void main(String[] args) {

    }

    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        backTrack(Arrays.stream(nums).boxed().collect(Collectors.toList()), new ArrayList<>());
        return res;
    }

    public void backTrack(List<Integer> nums, List<Integer> path) {
        if (nums.isEmpty()) {
            //没有元素可以选择了
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            //当前选择第i个元素
            //List.copyOf(nums) 返回一个不可修改的列表
            List<Integer> copy = new ArrayList<>(nums);
            Integer remove = copy.remove(i);
            path.add(remove);
            //继续选择下一个元素
            backTrack(copy, path);
            //以上将遍历完一种情况， 开始回溯, 由于nums链表每次都是复制的，nums不会受上一次回溯影响
            //但path需要将上一次添加的第 i 个元素移除， 然后进行下一轮循环
            path.remove(path.size() - 1);
        }
    }
}
