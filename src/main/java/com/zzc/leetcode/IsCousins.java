package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description 993. 二叉树的堂兄弟节点 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * @create 2023-07-17 11:32
 */
public class IsCousins {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;
        boolean cousins = new IsCousins().isCousins(node1, 4, 5);
        System.out.println(cousins);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.left == null || root.right == null) {
            return false;
        }
        int[] deepthAndFatherX = getDeepthAndFather(root, x, new int[]{0, root.val});
        int[] deepthAndFatherY = getDeepthAndFather(root, y, new int[]{0, root.val});
        return deepthAndFatherX[0] == deepthAndFatherY[0]
                && deepthAndFatherX[1] !=
                deepthAndFatherY[1];
    }

    public int[] getDeepthAndFather(TreeNode root, int x, int[] deepthAndFather) {
        if (root.val == x) {
            return deepthAndFather;
        }
        if (root.left != null) {
            int[] deepthAndFather1 = getDeepthAndFather(root.left, x, new int[]{deepthAndFather[0] + 1, root.val});
            if (deepthAndFather1[0] == -1) {
                if (root.right != null) {
                    return getDeepthAndFather(root.right, x, new int[]{deepthAndFather[0] + 1, root.val});
                }
            }
            return deepthAndFather1;
        }
        if (root.right != null) {
            return getDeepthAndFather(root.right, x, new int[]{deepthAndFather[0] + 1, root.val});
        }
        return new int[]{-1, -1};
    }
}
