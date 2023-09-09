package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description 543. 二叉树的直径 TODO
 * @create 2023-08-27 20:55
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        //直径经过根结点， 计算左右子节点的度
        int res1 = degree(root.left) + degree(root.right);
        //不经过根节点（在左子树）
        int res2 = diameterOfBinaryTree(root.left);
        //不经过根节点（在右子树）
        int res3 = diameterOfBinaryTree(root.right);

        return Math.max(Math.max(res1, res2), res3);
    }

    public int degree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(degree(root.left), degree(root.right)) + 1;
    }
}
