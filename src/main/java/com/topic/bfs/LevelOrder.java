package com.topic.bfs;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;



/**
 * @author zc.zhou
 * @Description 102. 二叉树的层序遍历
 * @create 2024-12-09 21:24
 */
public class LevelOrder {
  public List<List<Integer>> levelOrder(TreeNode root) {
    // bfs
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Deque<TreeNode> dq = new ArrayDeque<>();
    dq.offerLast(root);
    while (!dq.isEmpty()) {
      int size = dq.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode first = dq.pollFirst();
        list.add(first.val);
        if (first.left != null) {
          dq.offerLast(first.left);
        }
        if (first.right != null) {
          dq.offerLast(first.right);
        }
      }
      res.add(list);
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
