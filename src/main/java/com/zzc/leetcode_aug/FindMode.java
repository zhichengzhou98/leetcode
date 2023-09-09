package com.zzc.leetcode_aug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description Morris 中序遍历; 空间复杂度要求o(1)
 * @create 2023-08-26 22:00
 */
public class FindMode {
    public static void main(String[] args) {

    }

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int maxCount = map.values().stream().max(Integer::compareTo).get();
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == maxCount){
                list.add(e.getKey());
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(root.left, map);
        dfs(root.right, map);
    }
}
