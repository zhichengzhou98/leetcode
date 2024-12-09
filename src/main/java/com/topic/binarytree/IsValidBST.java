package com.topic.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 98. 验证二叉搜索树 中序遍历
 * @create 2024-12-09 21:34
 */
public class IsValidBST {
  List<Integer> res;
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    res = new ArrayList<>();
    // 前序遍历
    preOrder(root);
    // 遍历res 判断是否有序
    for (int i = 1; i < res.size(); i++) {
      if (res.get(i) <= res.get(i - 1)) {
        return false;
      }
    }
    return true;
  }

  public void preOrder(TreeNode root) {
    if (root.left != null) {
      preOrder(root.left);
    }
    res.add(root.val);
    if (root.right != null) {
      preOrder(root.right);
    }
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
