package com.zzc.leetcode_dec;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-12-18 12:03
 */
public class FindPeakElement {
    public static void main(String[] args) {
        FindPeakElement fPE = new FindPeakElement();
        int[] res = {1};
        fPE.findPeakElement(res);
    }

    public int findPeakElement(int[] nums) {
        return specificTarget(nums);
    }

    public int specificTarget(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = -1;
        while (l <= r) {
            int med = (r - l)/ 2 + l;
            int pre = med - 1;
            int next = med + 1;
            boolean flag1 = (pre < 0) || (nums[med] > nums[pre]);
            boolean flag2 = (next >= nums.length) || (nums[med] > nums[next]);
            if (flag1 && flag2) {
                return med;
            }else if (flag1 && !flag2) {
                l = med + 1;
            }else {
                r = med -1;
            }
        }
        return res;
    }
}
