package com.zzc.backtracking;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-14 20:55
 */
public class IsAdditiveNumber {
    public static void main(String[] args) {
        //System.out.println(Long.MAX_VALUE);
        IsAdditiveNumber iAN = new IsAdditiveNumber();
        System.out.println(iAN.isAdditiveNumber("0000"));
    }

    boolean flag;
    public boolean isAdditiveNumber(String num) {
        if (num.length() <= 2) {
            return false;
        }
        flag = false;
        int maxSize = (num.length() - 1) / 2;
        for (int i = 1; i <= maxSize; i++) {
            String firstStr = num.substring(0, i);
            if (!checkStr(firstStr)) {
                continue;
            }
            long f = Long.parseLong(firstStr);
            for (int j = i + 1; j < num.length(); j++) {
                String second = num.substring(i, j);
                if (checkStr(second)) {
                    long s = Long.parseLong(second);
                    dfs(f, s, num.substring(j));
                    if (flag) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void dfs(long f, long s, String leftStr) {
        String targetStr= String.valueOf(f + s);
        if (targetStr.length() == leftStr.length() && targetStr.equals(leftStr)) {
            flag = true;
            return;
        }

        if (leftStr.length() < targetStr.length()) {
            return;
        }
        String substring = leftStr.substring(0, targetStr.length());
        if (substring.equals(targetStr)) {
            dfs(s, Long.parseLong(substring), leftStr.substring(targetStr.length()));
        }
    }

    public boolean checkStr(String s) {
        return s.length() <= 1 || s.charAt(0) != '0';
    }
}
