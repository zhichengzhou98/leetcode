package com.topic.dfs;


import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-04 08:37
 */
public class IsSubtree {
  @Test
  void testFun() {
    TreeNode node1 = new TreeNode(3);
    TreeNode node2 = new TreeNode(4);
    TreeNode node3 = new TreeNode(5);
    TreeNode node4 = new TreeNode(1);
    TreeNode node5 = new TreeNode(2);
    node1.left = node2;
    node1.right = node3;
    node2.left = node4;
    node3.left = node5;


    TreeNode node6 = new TreeNode(3);
    TreeNode node7 = new TreeNode(1);
    TreeNode node8 = new TreeNode(2);
    node6.left = node7;
    node6.right = node8;
    System.out.println(isSubtree(node1, node6));
  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) {
      return true;
    }
    boolean flag = isSubtreeCurrentRoot(root, subRoot);
    if (flag) {
      return true;
    }
    if (root == null || subRoot == null) {
      return false;
    }
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  //判断以当前节点为根时， subRoot是不是root的子树
  private boolean isSubtreeCurrentRoot(TreeNode root, TreeNode subRoot) {
    if ((subRoot == null) && (root != null)) {
      return false;
    }
    if ((root == null) && (subRoot != null)) {
      return false;
    }
    if (root == null) {
      return true;
    }
    if (root.val != subRoot.val) {
      return false;
    }
    //root节点一样 必须保证以左右节点为根时，也满足关系
    return isSubtreeCurrentRoot(root.left, subRoot.left) && isSubtreeCurrentRoot(root.right,
        subRoot.right);
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
