package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-13 23:11
 */
public class SumRootToLeaf {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(1);
        node2.left = node4;
        node2.right = node5;
        node1.left = node2;
        node2.left = node3;//4 + 3 + 3 = 10
        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        int i = sumRootToLeaf.sumRootToLeaf(node1);
        System.out.println(i);
    }


    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return res(root, 0);

    }

    public int res(TreeNode root, int num) {
        num = num  * 2 + root.val;
        if (root.left != null && root.right != null) {
            return res(root.left, num) + res(root.right, num);
        } else if (root.left == null && root.right == null) {
            return num;
        } else if (root.left != null) {
            return res(root.left, num);
        } else {
            return res(root.right, num);
        }
    }
}
