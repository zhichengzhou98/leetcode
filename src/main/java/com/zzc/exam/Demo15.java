package com.zzc.exam;

/**
 * @author zzc
 * @Description
 * @create 2023-03-18 18:58
 */
public class Demo15 {


    private int res;

    public static void main(String[] args) {

    }

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        sum = res(root, sum, false);
        return sum;
    }

    public int res(TreeNode root, int res, boolean flag) {
        if(flag) {
            // flag 为 true 则为左子树
            if(root.left == null && root.right == null){
                res = res + root.val;
            }
        }
        if(root.left != null) {
            res = res(root.left, res,true);
        }

        if(root.right != null) {
            res =res(root.right, res,false);
        }
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