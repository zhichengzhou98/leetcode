package com.zzc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-13 21:06
 */
public class Partition {
    public static void main(String[] args) {
        Partition p = new Partition();
        System.out.println(p.partition("aab"));
    }

    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();

        dfs(new ArrayList<>(), s);
        return res;

    }

    public void dfs(List<String> singleRes, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(singleRes));
            return;
        }
        if (s.length() == 1) {
            //s一定是回文串
            singleRes.add(s);
            res.add(new ArrayList<>(singleRes));
            //回溯
            singleRes.remove(singleRes.size() - 1);
            return;
        }
        int maxCnt = s.length();
        for (int i = 1; i <= maxCnt ; i++) {
            String subS1 = s.substring(0, i);
            String subS2 = s.substring(i);
            if (checkHuiWen(subS1)) {
                singleRes.add(subS1);
                dfs(singleRes, subS2);
                singleRes.remove(singleRes.size()-1);
            }
        }
    }

    public boolean checkHuiWen(String s) {
        if (s.length() == 0) {
            return true;
        }

        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
