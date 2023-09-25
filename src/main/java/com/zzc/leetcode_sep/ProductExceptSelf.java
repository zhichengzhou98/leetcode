package com.zzc.leetcode_sep;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-25 21:21
 */
public class ProductExceptSelf {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        //前缀积
        int[] preProduct = new int[nums.length];
        preProduct[0] = 1;
        for (int i = 1; i < preProduct.length; i++) {
            preProduct[i] = preProduct[i - 1] * nums[i - 1];
        }

        //后缀积
        int[] sufProduct = new int[nums.length];
        sufProduct[sufProduct.length - 1] = 1;
        for (int i = sufProduct.length - 2; i >= 0; i--) {
            sufProduct[i] = sufProduct[i + 1] * nums[i + 1];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = preProduct[i] * sufProduct[i];
        }
        return res;
    }

   /* public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int cnt0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt0++;
            }else {
                product *= nums[i];
            }
        }
        if (cnt0 >= 2) {
            return new int[nums.length];
        }else if (cnt0 == 1) {
            int[] res = new int[nums.length];
            for (int i = 0; i < res.length; i++) {
                if (nums[i] != 0) {
                    res[i] = 0;
                }else {
                    res[i] = product;
                }
            }
            return res;
        }else {
            int[] res = new int[nums.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = product / nums[i];
            }
            return res;
        }
    }*/
}
