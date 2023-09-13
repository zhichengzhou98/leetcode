package com.zzc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-13 20:51
 */
public class PathSum {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(new ArrayList<>(), root, targetSum);
        return res;
    }

    public void dfs(List<Integer> singleRes, TreeNode current, int target) {
        if (current.left == null && current.right == null) {
            if (current.val == target){
                singleRes.add(current.val);
                res.add(new ArrayList<>(singleRes));
                //回溯
                singleRes.remove(singleRes.size()-1);
            }
            return;
        }
        if (current.left != null) {
            singleRes.add(current.val);
            dfs(singleRes, current.left, target - current.val);
            singleRes.remove(singleRes.size()-1);
        }
        if (current.right != null) {
            singleRes.add(current.val);
            dfs(singleRes, current.right, target - current.val);
            singleRes.remove(singleRes.size()-1);
        }
    }
}
