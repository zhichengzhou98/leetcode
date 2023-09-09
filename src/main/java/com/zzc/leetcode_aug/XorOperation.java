package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-22 20:28
 */
public class XorOperation {
    public static void main(String[] args) {
        System.out.println(new XorOperation().xorOperation(4, 3));
    }

    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            res = res ^ (start + 2 * i);
        }
        return res;
    }
}
