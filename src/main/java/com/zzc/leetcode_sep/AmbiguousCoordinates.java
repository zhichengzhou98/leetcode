package com.zzc.leetcode_sep;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-09 18:01
 */
public class AmbiguousCoordinates {
    public static void main(String[] args) {
        AmbiguousCoordinates ac = new AmbiguousCoordinates();
        System.out.println(ac.ambiguousCoordinates("(0123)"));
    }
    public List<String> ambiguousCoordinates(String s) {
        String num = s.substring(1, s.length() - 1);
        List<String> res = new ArrayList<>();
        for (int i = 1; i < num.length(); i++) {
            String x = num.substring(0, i);
            String y = num.substring(i);
            if (checkNum(x) && checkNum(y)) {
                List<String> listX = generatePossibleNum(x);
                List<String> listY = generatePossibleNum(y);
                for (int j = 0; j < listX.size(); j++) {
                    for (int k = 0; k < listY.size(); k++) {
                        res.add(generateCoordinate(listX.get(j), listY.get(k)));
                    }

                }
            }
        }
        return res;
    }

    public String generateCoordinate(String x, String y) {
        return "(" + x + ", " + y + ")";
    }

    public List<String> generatePossibleNum(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 1) {
            if (s.charAt(0) == '0') {
                //0 开头  0123  00123, 只能在第一个0后加点
                String newStr = "0." + s.substring(1);
                res.add(newStr);
            }else if (s.charAt(s.length() - 1) == '0') {
                //0 结尾  1030， 13400 不能加 .
                res.add(s); //已经加过一次
            }else {
                // 首尾都不为0 1334
                res.add(s);
                int len = s.length();
                for (int i = 1; i < len; i++) {
                    String newStr =s.substring(0,i) + "." + s.substring(i);
                    res.add(newStr);
                }
            }
        }else {
            res.add(s);
        }
        return res;
    }


    // 00 000 ...非法字符串   012340也是非法字符串
    public boolean checkNum(String s) {
        if (s.length() >= 2) {
            return s.charAt(0) != '0' || s.charAt(s.length() - 1) != '0';
        }
        return true;
    }
}
