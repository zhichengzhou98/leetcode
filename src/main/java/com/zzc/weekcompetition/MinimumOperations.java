package com.zzc.weekcompetition;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-03 10:37
 */
public class MinimumOperations {
    public static void main(String[] args) {
        System.out.println(minimumOperations("10"));
    }
    public static int minimumOperations(String num) {

        int res = Integer.MAX_VALUE;
        //方向遍历num，遇到不为0 或 5 直接跳过
        int r = num.length() - 1;
        //记录操作的次数
        int cnt = 0;
        while (r >=0) {
            while (r >= 0) {
                if (num.charAt(r) != '0' && num.charAt(r) != '5') {
                    r--;
                }else {
                    break;
                }
            }
            cnt = num.length() - 1 - r;

            if (r == -1) {
                res = Math.min(res, cnt);
                break;
            }

            if (num.charAt(r) == '0') {
                int temp = cnt;
                res = Math.min(res, cnt + r);
                int l = r - 1;
                //向前找最近的0 或 5
                while (l >=0) {
                    if (num.charAt(l) != '0' && num.charAt(l) != '5') {
                        l--;
                        temp++;

                    }else {
                        res = Math.min(res, temp);
                        break;
                    }
                }

                r = l;
            }else if (num.charAt(r) == '5') {
                int temp = cnt;
                int l = r - 1;
                //向前找最近的2 或 7
                while (l >=0) {
                    if (num.charAt(l) != '2' && num.charAt(l) != '7') {
                        l--;
                        temp++;

                    }else {
                        res = Math.min(res, temp);
                        break;
                    }
                }
                r--;
            }
        }
        cnt = num.length() - 1 - r;
        res = Math.min(res, cnt);
        return res == Integer.MAX_VALUE?1: res;
    }
}
