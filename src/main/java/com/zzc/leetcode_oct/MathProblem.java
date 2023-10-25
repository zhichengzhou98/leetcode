package com.zzc.leetcode_oct;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-25 21:30
 */
public class MathProblem {
    public static void main(String[] args) {
        MathProblem mP = new MathProblem();
        System.out.println(mP.mathProblem("99x=99"));
    }

    public String mathProblem(String s) {
        String[] split = s.split("=");
        int[] left = solvingEquations(split[0]);
        int[] right = solvingEquations(split[1]);
        if (left[0] == right[0]) {
            if (left[1] == right[1]) {
                return "Infinite solutions";
            }else {
                return "No solution";
            }
        }
        int answer = (right[1] - left[1]) / (left[0] - right[0]);
        return "x=" + answer;
    }

    //统计等号左右两边x的系数以及数值
    public int[] solvingEquations(String s) {
        int cntX = 0;
        int num = 0;
        int l = 0;
        boolean sign = true;// 符号 默认为正
        while (l < s.length()) {
            if (s.charAt(l) == '+') {
                sign = true;
                l++;
            }else if (s.charAt(l) == '-') {
                sign = false;
                l++;
            }else if (s.charAt(l) == 'x') {
                if (sign) {
                    cntX++;
                }else {
                    cntX--;
                }
                l++;
            }else {
                //为数字 后面两个也可能是数字，也有可能是x
                int r = l + 1;
                while (r < s.length() && Character.isDigit(s.charAt(r))) {
                    r++;
                }
                int num1 = Integer.parseInt(s.substring(l, r));
                if (r < s.length() && s.charAt(r) == 'x') {
                    if (sign) {
                        cntX += num1;
                    }else {
                        cntX -= num1;
                    }
                    l = r + 1;
                }else {
                    if (sign) {
                        num += num1;
                    }else {
                        num -= num1;
                    }
                    l = r;
                }
            }
        }
        return new int[]{cntX, num};
    }
}
