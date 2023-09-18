package com.zzc.leetcode_sep;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-18 12:21
 */
public class RobIII {
    Map<TreeNode, Integer> map;
    public int rob(TreeNode root) {
        map = new HashMap<>();
        return robIII(root);
    }

    //以当前结点最大的值
    public int robIII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        //选根结点，根结点左右子结点不能选
        int x = root.val;
        //不选根结点
        int y = 0;
        if (root.left != null) {
            if (root.left.left != null) {
                x +=robIII(root.left.left);
            }
            if (root.left.right != null) {
                x +=robIII(root.left.right);
            }
            //不选根结点
            y += robIII(root.left);
        }
        if (root.right != null) {
            if (root.right.left != null) {
                x +=robIII(root.right.left);
            }
            if (root.right.right != null) {
                x +=robIII(root.right.right);
            }
            //不选根结点
            y += robIII(root.right);
        }
        int res = Math.max(x, y);
        map.put(root, res);
        return res;
    }
    /*public int robIII(TreeNode root) {
        if (root == null) {
            map.put(root, 0);
            return 0;
        }
        //选根结点，根结点左右子结点不能选
        int x = root.val;
        if (root.left != null) {
            x += map.getOrDefault(root.left.left, robIII(root.left.left)) +
                    map.getOrDefault(root.left.right, robIII(root.left.right));
        }
        if (root.right != null) {
            x += map.getOrDefault(root.right.left, robIII(root.right.left)) +
                    map.getOrDefault(root.right.right, robIII(root.right.right));
        }

        //不选根结点
        int y = map.getOrDefault(root.left,robIII(root.left)) +
                map.getOrDefault(root.right,robIII(root.right));
        int res = Math.max(x, y);
        map.put(root, res);
        return res;
    }*/
}
