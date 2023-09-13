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
        
    }
    
    List<TreeNode> res;
    TreeNode root;
    public List<TreeNode> generateTrees(int n) {
        res = new ArrayList<>();
        List<Integer> nodeVals = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nodeVals.add(i);
        }
        for (int i = 0; i < nodeVals.size(); i++) {
            int rootVal = nodeVals.get(i);
            root = new TreeNode(rootVal);
            List<Integer> copy = new ArrayList<>(nodeVals);
            nodeVals.remove(i);
            dfs(copy, root);
        }
        
        return res;
    }

    public TreeNode dfs(List<Integer> nodeVals, TreeNode node) {
        if (nodeVals.size() == 0) {
            res.add(root);
            return null;
        }
        for (int i = 0; i < nodeVals.size(); i++) {
            Integer first = nodeVals.get(i);
            if (first > node.val) {
                //右结点
                List<Integer> copy = new ArrayList<>(nodeVals);
                copy.remove(i);
                node.right = dfs(copy, new TreeNode(first));
                //回溯
                node.right = null;
            }
        }
        return null;
    }
}
