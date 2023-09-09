package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-02 22:27
 */
public class GetTargetCopy {
    public static void main(String[] args) {
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null) {
            return null;
        }

        if (cloned.val == target.val) {
            return cloned;
        }

        return getTargetCopy(original, cloned.left,target) == null ?
                getTargetCopy(original, cloned.right,target) : getTargetCopy(original, cloned.left,target);
    }
}
