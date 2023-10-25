package com.zzc.leetcode_oct;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-25 12:15
 */
public class PunishmentNumber {
    public static void main(String[] args) {
        PunishmentNumber pN = new PunishmentNumber();
        System.out.println(pN.judge(5));
        System.out.println(pN.punishmentNumber(37));
    }

    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n ; i++) {
            if (judge(i)) {
                res += i * i;
            }
        }
        return res;
    }
    boolean flag;
    public boolean judge(int n) {
        flag = false;
        dfs(String.valueOf(n * n), n);
        return flag;
    }

    public void dfs(String s, int target) {
        if ("".equals(s) && target == 0) {
            flag = true;
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(0, i + 1);
            int i1 = Integer.parseInt(s1);
            if (i1 > target) {
                return;
            }else {
                dfs(s.substring(i + 1), target - i1);
                if (flag) {
                    return;
                }
            }
        }
    }
}

