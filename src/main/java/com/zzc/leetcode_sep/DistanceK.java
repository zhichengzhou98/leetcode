package com.zzc.leetcode_sep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-16 16:14
 */
public class DistanceK {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        node3.left = node5;
        node3.right = node1;

        DistanceK dk = new DistanceK();
        System.out.println(dk.distanceK(node3, node5, 2));
        //TreeNode node7 = new TreeNode(5);
        //TreeNode node4 = new TreeNode(5);
    }

    Set<Integer> res;

    List<TreeNode> path;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res = new HashSet<>();
        path = new ArrayList<>();
        getPath(root, target);
        int cnt = 1;
        for (int i = path.size() - 2; i >= 0 ; i--) {
            TreeNode pre = path.get(i);
            TreeNode after = path.get(i + 1);
            if (pre.left == after) {
                if (k - cnt > 0 && pre.right != null) {
                    dfs(k - cnt - 1, pre.right);
                }else if (k - cnt == 0) {
                    res.add(pre.val);
                }
            }else {
                if (k - cnt > 0 && pre.left != null) {
                    dfs(k - cnt - 1, pre.left);
                }else if (k - cnt == 0) {
                    res.add(pre.val);
                }
            }
            cnt++;
        }
        dfs(k, target);
        return res.stream().collect(Collectors.toList());
    }

    public void getPath(TreeNode root, TreeNode target) {
        if (root == target) {
            path.add(root);
            return;
        }
        if (root.left != null) {
            path.add(root);
            getPath(root.left, target);
            if (path.get(path.size() - 1).val == target.val) {
                return;
            }
            path.remove(path.size() - 1);
        }


        if (root.right != null) {
            path.add(root);
            getPath(root.right, target);
            if (path.get(path.size() - 1).val == target.val) {
                return;
            }
            path.remove(path.size() - 1);
        }
    }

    public void dfs(int k, TreeNode current) {
        if (k == 0) {
            res.add(current.val);
        }

        if (current.left != null) {
            dfs(k-1, current.left);
        }

        if (current.right != null) {
            dfs(k-1, current.right);
        }
    }
}
