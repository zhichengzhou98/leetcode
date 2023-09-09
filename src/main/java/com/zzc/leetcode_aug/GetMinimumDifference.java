package com.zzc.leetcode_aug;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-27 20:26
 */
public class GetMinimumDifference {
    public static void main(String[] args) {

    }

    int pre;
    int min;
    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        min = Integer.MAX_VALUE;
        inorder(root);


        return min;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (pre == -1) {
            pre = root.val;
        }else {
            min = Math.min(min, root.val - pre);
            pre = root.val;
        }
        inorder(root.right);
    }

    /*public int getMinimumDifference(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.size() - 1; i++) {
            min = Math.min(min, res.get(i + 1) - res.get(i));

        }
        return min;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }*/
}
