package com.zzc.leetcode_aug;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-27 20:43
 */
public class ReverseStr {
    public static void main(String[] args) {

    }
    public String reverseStr(String s, int k) {
        //剩余字符数小于k
        if (s.length() < k) {
            return new StringBuilder(s).reverse().toString();
        }else if (s.length() < 2 * k) {
            return new StringBuilder(s.substring(0, k)).reverse().toString() + s.substring(k);
        }else {
            return new StringBuilder(s.substring(0, k)).reverse() + s.substring(k, 2 * k)+ reverseStr(s.substring(2 * k), k);
        }
    }

}
