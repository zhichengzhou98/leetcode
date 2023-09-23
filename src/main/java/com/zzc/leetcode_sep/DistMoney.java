package com.zzc.leetcode_sep;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-22 12:03
 */
public class DistMoney {
    public int distMoney(int money, int children) {
        int left = money - children;
        if (left < 0) {
            return -1;
        }else if (left == 0) {
            return 0;
        }
        if (money == 4 && children == 1) {
            return -1;
        }

        int mod = left % 7;
        int cnt = left / 7;
        if (mod == 0) {
            if (cnt > children) {
                return children - 1;
            }else  {
                return cnt;
            }
        }else if (mod == 3){
            if (cnt > children) {
                return children - 1;
            }else  if (cnt == children){
                return children - 1;
            }else {
                if (children - cnt > 1) {
                    return Math.max(cnt, 0);
                }
                return Math.max(cnt - 1, 0);
            }
        }else {
            if (cnt > children) {
                return children - 1;
            }else  if (cnt == children){
                return children - 1;
            }else {
                return cnt;
            }
        }
    }
}
