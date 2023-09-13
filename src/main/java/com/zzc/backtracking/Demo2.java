package com.zzc.backtracking;

import java.util.*;

/**
 * @author zzc
 * @Description
 * @create 2022-12-20 22:38
 */
public class Demo2 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode5;
        List<String> strings = binaryTreePaths(treeNode1);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root != null) {
            StringBuilder sb = new StringBuilder(root.val+"");
            TreeNode left = root.left;
            TreeNode right = root.right;
            List<TreeNode> treeNodes = new ArrayList<>();
            if (left != null) {
                treeNodes.add(left);
            }
            if (right != null) {
                treeNodes.add(right);
            }
            TreeNode[] nodes = new TreeNode[]{left, right};
            dfs(list, sb, treeNodes, 0);
        }
        return list;

    }

    /**
     * @param res  所有路径
     * @param path 从根节点到叶子节点的路径
     */
    public static void dfs(List<String> res, StringBuilder path, List<TreeNode> treeNodes, int begin) {
        if(treeNodes.size()==0){
            res.add(path.toString());
            return;
        }
        for (int i = begin; i < treeNodes.size(); i++) {
            TreeNode tn = treeNodes.get(i);
            //path.append("->").append(tn.val);
            StringBuilder append = new StringBuilder(path).append("->").append(tn.val);
            TreeNode left = tn.left;
            TreeNode right = tn.right;
            List<TreeNode> nodes1 = new ArrayList<>();
            if (left != null) {
                nodes1.add(left);
            }
            if (right != null) {
                nodes1.add(right);
            }
            dfs(res, append, nodes1, 0);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    List<Integer> resStr;
    TreeNode() {
        resStr = new ArrayList<>();
    }

    TreeNode(int val) {
        resStr = new ArrayList<>();
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        //层序遍历
        List<TreeNode> s = new ArrayList<>();
        s.add(this);
        while (!s.isEmpty()) {
            TreeNode current = s.remove(0);
            if (current != null) {
                resStr.add(current.val);
                if (current.left!=null || current.right != null) {
                    s.add(current.left);
                    s.add(current.right);
                }else {
                    if (s.size() == 1 && s.get(0) == null) {
                        s.remove(0);
                    }
                }
            }else {
                resStr.add(null);
            }
        }
        return resStr.toString();
    }
}