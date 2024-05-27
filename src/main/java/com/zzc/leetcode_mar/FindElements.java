package com.zzc.leetcode_mar;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-03-12 22:11
 */
public class FindElements {
    Set<Integer> set;
    public FindElements(TreeNode root) {
        root.val = 0;
        set = new HashSet<>();
        set.add(0);
        dfs(root);
    }

    public void dfs(TreeNode root) {
        if (root.left != null) {
            root.left.val = 2 * root.val + 1;
            set.add(root.left.val);
            dfs(root.left);
        }
        if (root.right != null) {
            root.right.val = 2 * root.val + 2;
            set.add(root.right.val);
            dfs(root.right);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
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
