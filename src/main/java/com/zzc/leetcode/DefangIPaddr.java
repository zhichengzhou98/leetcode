package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-21 12:19
 */
public class DefangIPaddr {
    public static void main(String[] args) {
        System.out.println(new DefangIPaddr().defangIPaddr("1.1.1.1"));
    }
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
