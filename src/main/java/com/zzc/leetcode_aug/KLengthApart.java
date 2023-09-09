package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-16 20:49
 */
public class KLengthApart {
    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{1,0,0,0,1,0,0,1}, 2));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        if (nums.length == 1) {
            return false;
        }
        int left = 0;
        int right = 1;
        while (right < nums.length && left < nums.length) {
            while (left < nums.length && nums[left] != 1) {
                left++;
            }
            right = left + 1;

            while (right < nums.length && nums[right] != 1) {
                right++;
            }
            if (right >= nums.length) {
                break;
            }
            if (right - left -1 < k) {
                return false;
            }
            left = right;
        }
        return true;
    }
}
