package com.zzc.leetcode_aug;

import com.zzc.utils.TreeNodeUtils;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description 543. 二叉树的直径
 * @create 2023-08-27 20:55
 */
public class DiameterOfBinaryTree {

  @Test
  void testFun() {
    TreeNode root = TreeNodeUtils.generate("array", TreeNode.class, Integer.class);
    //System.out.println(root);
    System.out.println(diameterOfBinaryTree(root));
  }

  Map<String, Integer> map = new HashMap<>();
  Map<String, Integer> map1 = new HashMap<>();

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return 0;
    }
    if (map1.containsKey(root.toString())) {
      return map1.get(root.toString());
    }
    //直径经过根结点， 计算左右子节点的度
    int res1 = degree(root.left) + degree(root.right);
    //不经过根节点（在左子树）
    int res2 = diameterOfBinaryTree(root.left);
    //不经过根节点（在右子树）
    int res3 = diameterOfBinaryTree(root.right);
    int res = Math.max(Math.max(res1, res2), res3);
    map1.put(root.toString(), res);
    return res;
  }

  public int degree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (map.containsKey(root.toString())) {
      return map.get(root.toString());
    }
    int res = Math.max(degree(root.left), degree(root.right)) + 1;
    map.put(root.toString(), res);
    return res;
  }
}
