package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-29 22:39
 */
public class FindTilt {
    public static void main(String[] args) {

    }

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null){
            left = root.left.val;
        }
        if (root.right != null){
            right = root.right.val;
        }

        return Math.abs(right - left) + findTilt(root.left) + findTilt(root.right);
    }
}
