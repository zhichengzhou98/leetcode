package com.zzc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-12 19:59
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        RestoreIpAddresses ip = new RestoreIpAddresses();
        System.out.println(ip.restoreIpAddresses("101023"));
    }

    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        List<String> singleRes = new ArrayList<>();
        backTrack(s, 3, singleRes);
        return res;
    }
    public void backTrack(String s, int cut, List<String> list) {
        if (cut == 0) {
            //4段全部切完 检查s是否满足
            if (checkStr(s)) {
                list.add(s);
                res.add(String.join(".", list));
                //回溯
                list.remove(list.size() - 1);
            }
            return;
        }

        //每次最大的切割长度
        int maxSize = Math.min(3, s.length() - 1);
        for (int i = 1; i <= maxSize; i++) {
            String str = s.substring(0, i);
            if (checkStr(str)) {
                list.add(str);
                backTrack(s.substring(i), cut - 1, list);
                //回溯
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean checkStr(String str) {
        if (str.length() > 3) {
            return false;
        }
        if (str.length() == 1) {
            return true;
        }
        if (str.charAt(0) == '0') {
            return false;
        }
        int i = Integer.parseInt(str);
        return i <= 255;
    }

}
