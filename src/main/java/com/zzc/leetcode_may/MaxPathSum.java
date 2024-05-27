package com.zzc.leetcode_may;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-05-20 16:53
 */
public class MaxPathSum {

    Map<TreeNode, int[]> map;

    int max;

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(-1);
        TreeNode node3 = new TreeNode(-2);
        node1.left = node2;
        node1.right = node3;
        System.out.println(maxPathSum(node1));
    }

    public int maxPathSum(TreeNode root) {
        map = new HashMap<>();
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    public int[] dfs(TreeNode root) {
        if (map.containsKey(root)) {
            return map.get(root);
        }
        //左（以该节点为终点左边部分） 右 中（经过该节点）
        int[] res = new int[3];
        if (root == null) {
            return res;
        }
        res[2] = root.val;
        if (root.left == null) {
            res[0] = root.val;
        } else {
            int[] resLeft = dfs(root.left);
            int temp = Math.max(Math.max(resLeft[0], resLeft[1]), 0);
            res[0] = root.val + temp;
            res[2] += temp;
        }
        if (root.right == null) {
            res[1] = root.val;
        } else {
            int[] resRight = dfs(root.right);
            int temp = Math.max(Math.max(resRight[0], resRight[1]), 0);
            res[1] = root.val + temp;
            res[2] += temp;
        }
        max = Math.max(Math.max(Math.max(res[0], res[1]), res[2]), max);
        map.put(root, res);
        return res;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}