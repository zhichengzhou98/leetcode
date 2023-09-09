package com.zzc.leetcode_sep;

import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-06 12:07
 */
public class LcaDeepestLeaves {
    public static void main(String[] args) {
        LcaDeepestLeaves leaves = new LcaDeepestLeaves();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;

        node2.right = node4;
        //node3.left = node5;
        System.out.println(leaves.lcaDeepestLeaves(node1).val);
        System.out.println(leaves.res);
    }
    List<List<TreeNode>> res;
    public TreeNode lcaDeepestLeaves(TreeNode root) {

        return dfs(root).key;
    }

    public Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(root, 0);
        }
        Pair leftPair = dfs(root.left);
        Pair rightPair = dfs(root.right);
        if (leftPair.value > rightPair.value) {
            return new Pair(leftPair.key, leftPair.value + 1);
        }else if (leftPair.value < rightPair.value) {
            return new Pair(rightPair.key, rightPair.value + 1);
        }
        return new Pair(root, leftPair.value);
    }

    /*public TreeNode lcaDeepestLeaves(TreeNode root) {
        res = new ArrayList<>();

        dfs(root, new ArrayList<TreeNode>());
        Integer maxLength = res.stream().map(l -> l.size()).max(Integer::compareTo).get();
        List<List<TreeNode>> collect = res.stream().filter(l -> l.size() == maxLength).collect(Collectors.toList());
        TreeNode t;
        if (collect.size() == 1) {
            t = collect.get(0).get(maxLength - 1);
        }else {
            t = collect.get(0).get(0);
            for (int i = 1; i < maxLength; i++) {
                TreeNode temp = collect.get(0).get(i);
                boolean flag = false;
                for (int j = 1; j < collect.size(); j++) {
                    if (temp != collect.get(j).get(i)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    t = temp;
                }else {
                    break;
                }
            }
        }
        return t;
    }

    public void dfs(TreeNode root, List<TreeNode> sb) {
        if (root == null) {
            return;
        }
        sb.add(root);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(sb));

            return;
        }
        if (root.left != null) {
            dfs(root.left, sb);
            sb.remove(sb.size()-1);
        }

        if (root.right != null) {
            dfs(root.right, sb);
            sb.remove(sb.size()-1);
        }
    }*/
    /*public TreeNode lcaDeepestLeaves(TreeNode root) {
        res = new ArrayList<>();

        dfs(root, new ArrayList<TreeNode>());
        Integer maxLength = res.stream().map(l -> l.size()).max(Integer::compareTo).get();
        List<List<TreeNode>> collect = res.stream().filter(l -> l.size() == maxLength).collect(Collectors.toList());
        TreeNode t;
        if (collect.size() == 1) {
            t = collect.get(0).get(maxLength - 1);
        }else {
            t = collect.get(0).get(0);
            for (int i = 1; i < maxLength; i++) {
                TreeNode temp = collect.get(0).get(i);
                boolean flag = false;
                for (int j = 1; j < collect.size(); j++) {
                    if (temp != collect.get(j).get(i)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    t = temp;
                }else {
                    break;
                }
            }
        }
        return t;
    }

    public void dfs(TreeNode root, List<TreeNode> sb) {
        if (root == null) {
            return;
        }
        sb.add(root);
        if (root.left == null && root.right == null) {
            res.add(sb);
        }
        if (root.left != null) {
            List<TreeNode> newList = new ArrayList<>(sb);

            dfs(root.left, newList);
        }
        if (root.right != null) {
            List<TreeNode> newList = new ArrayList<>(sb);
            dfs(root.right, newList);
        }
    }*/
}


class Pair {
    //公共祖先
    TreeNode key;
    //度
    int value;

    public Pair() {
    }

    public Pair(TreeNode key, int value) {
        this.key = key;
        this.value = value;
    }
}