package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-11 21:49
 */
public class IsUnivalTree {
    public static void main(String[] args) {

    }

    public boolean isUnivalTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null) {
            return root.val == root.right.val && isUnivalTree(root.right);
        }
        if (root.right == null) {
            return root.val == root.left.val && isUnivalTree(root.left);
        }
        return root.left.val == root.val &&
                isUnivalTree(root.right) &&
                root.val == root.right.val &&
                isUnivalTree(root.left);
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