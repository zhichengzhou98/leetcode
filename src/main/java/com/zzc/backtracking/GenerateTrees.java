package com.zzc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-12 20:50
 */
public class GenerateTrees {

    public static void main(String[] args) {
        GenerateTrees gt = new GenerateTrees();
        System.out.println(gt.generateTrees(3));
        /*TreeNode node3 = new TreeNode(3);

        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node3.left = node2;
        node2.left = node1;
        System.out.println(node3);*/
    }
    

    public List<TreeNode> generateTrees(int n) {

        return dfs(1, n, n);
    }

    public List<TreeNode> dfs(int start, int end, int n) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = dfs(start, i - 1, n);
            List<TreeNode> rightTrees = dfs(i + 1, end, n);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
