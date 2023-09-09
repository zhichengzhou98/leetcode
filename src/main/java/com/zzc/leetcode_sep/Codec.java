package com.zzc.leetcode_sep;


import java.util.*;
import java.util.stream.IntStream;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-04 12:20
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //层序遍历 bfs
        if (root == null) {
            return "";
        }
        List<String> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //取出元素
                TreeNode poll = queue.poll();
                res.add(String.valueOf(poll.val));
                //存入该元素的左右结点
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }

        return String.join(",", res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }

        int[] array = Arrays.stream(data.split(",")).mapToInt(Integer::valueOf).toArray();
        TreeNode root = new TreeNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            generateTree(root, array[i]);
        }
        return root;
    }

    public void generateTree(TreeNode root, int val) {
        if (root.val > val) {
            //往左结点放
            if (root.left == null) {
                TreeNode left = new TreeNode(val);
                root.left = left;
            }else {
                generateTree(root.left, val);
            }
        }else {
            if (root.right == null) {
                TreeNode right = new TreeNode(val);
                root.right = right;
            }else {
                generateTree(root.right, val);
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
