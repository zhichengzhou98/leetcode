package com.zzc.leetcode_dec;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-04 20:48
 */
public class BstToGst {
    List<TreeNode> list;
    public TreeNode bstToGst(TreeNode root) {
        //中序遍历
        list = new ArrayList<>();
        midDfs(root);
        for (int i = list.size() - 2; i >= 0 ; i--) {
            TreeNode treeNode = list.get(i);
            TreeNode next = list.get(i + 1);
            treeNode.val = treeNode.val + next.val;
        }
        return root;
    }

    public void midDfs(TreeNode root) {
        if (root.left != null) {
            midDfs(root.left);
        }
        list.add(root);
        if (root.right != null) {
            midDfs(root.right);
        }
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
