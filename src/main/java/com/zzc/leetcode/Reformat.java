package com.zzc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-11 21:06
 */
public class Reformat {
    public static void main(String[] args) {
        System.out.println(reformat("a0b1c2"));
    }
    public static String reformat(String s) {
        List<Character> charList = new ArrayList<>();
        List<Character> numList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                charList.add(s.charAt(i));
            }else {
                numList.add(s.charAt(i));
            }
        }
        if (Math.abs(numList.size() - charList.size()) >= 2) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (charList.size() > numList.size()) {
            int i = 0;
            for (; i < numList.size(); i++) {
                sb.append(charList.get(i)).append(numList.get(i));
            }
            return sb.append(charList.get(i)).toString();
        }else if (charList.size() < numList.size()) {
            int i = 0;
            for (; i < charList.size(); i++) {
                sb.append(numList.get(i)).append(charList.get(i));
            }
            return sb.append(numList.get(i)).toString();
        }else {
            int i = 0;
            for (; i < charList.size(); i++) {
                sb.append(numList.get(i)).append(charList.get(i));
            }
        }
        return sb.toString();
    }
}
