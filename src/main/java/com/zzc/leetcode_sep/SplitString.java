package com.zzc.leetcode_sep;

import java.util.Objects;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-04 21:17
 */
public class SplitString {
    public static void main(String[] args) {
        String str = "0021";
        System.out.println(Integer.parseInt(str));
        SplitString splitString = new SplitString();
        System.out.println(splitString.deletePrefixZero("000001"));
        //System.out.println(splitString.splitString("1000000000999999999"));
        System.out.println(splitString.splitString("200100"));
    }

    public boolean splitString(String s) {
        s = deletePrefixZero(s);
        if ("".equals(s)) {
            return false;
        }
        // 109 -> 遍历长度为 s.length() / 2 + 1
        for (int i = 1; i <= s.length() / 2 + 1; i++) {
            //第一个数
            long firstNum = Long.parseLong(s.substring(0,i));
            String nextStr = String.valueOf(firstNum - 1);
            String other = s.substring(i);
            if (checkNum(other, nextStr)) {
                return true;
            }
        }
        return false;
    }

    //第一次调用时, s可能为"", "001"
    //递归时，s一定不为"", 如果为"", 说明上一步已经比较完了, 在上一步就已经返回true了
    public boolean checkNum(String s, String target) {
        if ("".equals(s)) {
            return false;
        }
        //去掉前导0
        s = deletePrefixZero(s);
        if ("0".equals(target)) {
            return "".equals(s);
        }
        if (target.length() > s.length()) {
            return false;
        }
        if (target.equals(s)) {
            return true;
        }
        String compareStr = s.substring(0, target.length());
        if (!target.equals(compareStr)) {
            return false;
        }else {
            String nextStr = String.valueOf(Long.parseLong(target) - 1);
            String other = s.substring(target.length());
            return checkNum(other, nextStr);
        }
    }

    public String deletePrefixZero(String s) {
        if (Objects.equals(s, "")) {
            return s;
        }
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }
}
