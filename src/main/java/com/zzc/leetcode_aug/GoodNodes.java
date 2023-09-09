package com.zzc.leetcode_aug;


/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-25 21:07
 */
public class GoodNodes {
    public static void main(String[] args) {

    }
    public int goodNodes(TreeNode root) {
        return dfs(Integer.MIN_VALUE, root);
    }

    public int dfs(int max, TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.val >= max) {
            max = root.val;
            return 1 + dfs(max, root.left) + dfs(max, root.right);
        }
        return dfs(max, root.left) + dfs(max, root.right);
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
