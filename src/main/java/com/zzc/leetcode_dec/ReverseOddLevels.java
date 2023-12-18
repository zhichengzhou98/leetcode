package com.zzc.leetcode_dec;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-15 21:39
 */
public class ReverseOddLevels {
    public TreeNode reverseOddLevels(TreeNode root) {
        boolean flag = false;
        List<TreeNode> list = new ArrayList<>();
        if (root != null) {
            list.add(root);
            while (!list.isEmpty()) {
                int size = list.size();

                if (flag) {
                    //奇数层 交换值
                    int left = 0;
                    int right = size - 1;
                    while (right > left) {
                        TreeNode leftNode = list.get(left);
                        int temp = leftNode.val;

                        TreeNode rightNode = list.get(right);
                        leftNode.val = rightNode.val;
                        rightNode.val = temp;
                        left++;
                        right--;

                    }
                }
                for (int i = 0; i < size; i++) {
                    TreeNode remove = list.remove(0);
                    if (remove.left !=null) {
                        list.add(remove.left);
                    }
                    if (remove.right !=null) {
                        list.add(remove.right);
                    }
                }
                flag = !flag;
            }
        }
        return root;
    }
}
