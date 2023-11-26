package com.zzc.leetcode_nov;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-25 18:48
 */
public class PseudoPalindromicPaths {
    public static void main(String[] args) {

    }


    int num;

    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, new int[9]);
        return num;
    }

    public boolean check(int[] cnts) {
        //统计cnts中值为奇数的个数
        int result = 0;
        for (int num : cnts) {
            if (num % 2 == 1) {
                result++;
            }
        }
        return result <= 1;
    }

    public int dfs(TreeNode root, int[] cnts) {
        cnts[root.val - 1]++;
        if (root.left == null && root.right == null) {
            if (check(cnts)) {
                num++;
            }
            return root.val;
        }
        if (root.left != null) {
            int res = dfs(root.left, cnts);
            cnts[res - 1]--;
        }
        if (root.right != null) {
            int res = dfs(root.right, cnts);
            cnts[res - 1]--;
        }
        return root.val;
    }

   /* public void dfs(TreeNode root, List<Integer> res){
        res.add(root.val);
        if (root.left == null && root.right == null) {
            if (check(res)) {
                num++;
            }
            res.remove(res.size() -1);
            return;
        }
        if (root.left != null) {
            dfs(root.left, res);
        }
        if (root.right != null) {
            dfs(root.right, res);
        }

    }*/

   /* public void dfs(TreeNode root, List<Integer> res){
        res.add(root.val);
        if (root.left == null && root.right == null) {
            if (check(res)) {
                num++;
            }
            return;
        }
        if (root.left != null) {
            dfs(root.left, new ArrayList<>(res));
        }
        if (root.right != null) {
            dfs(root.right, new ArrayList<>(res));
        }

    }*/
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
