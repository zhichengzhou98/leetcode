package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-12 21:18
 */
public class RangeSumBST {
    public static void main(String[] args) {

    }


    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }else {
            return rangeSumBST(root.right, low, high);
        }
    }

    /*public int getSum(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val >= low && root.val <= high) {
            return root.val + getSum(root.left, low, high) + getSum(root.right, low, high);
        }
        return getSum(root.left, low, high) + getSum(root.right, low, high);
    }*/
}
