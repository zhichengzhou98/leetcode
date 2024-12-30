package com.topic.dfs;

/**
 * @author zc.zhou
 * @Description 1367. 二叉树中的链表
 * @create 2024-12-30 20:42
 */
public class IsSubPath {
  public boolean isSubPath(ListNode head, TreeNode root) {
    return dfs(head, root, true);
  }

  public boolean dfs(ListNode head, TreeNode root, boolean canSkip) {
    if (canSkip) {
      if (head == null) {
        return true;
      }
      if (root != null) {
        boolean skipRes = dfs(head, root.left, true) || dfs(head, root.right, true);
        if (head.val != root.val) {
          return skipRes;
        } else {
          return dfs(head.next, root.left, false) || dfs(head.next, root.right, false) || skipRes;
        }
      }
      return false;
    } else {
      if (head == null) {
        return true;
      }
      if (root != null) {
        if (head.val != root.val) {
          return false;
        } else {
          return dfs(head.next, root.left, false) || dfs(head.next, root.right, false);
        }
      }
      return false;
    }
  }
}
