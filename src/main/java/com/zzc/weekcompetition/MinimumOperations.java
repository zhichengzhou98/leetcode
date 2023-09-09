package com.zzc.weekcompetition;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-03 10:37
 */
public class MinimumOperations {
    public static void main(String[] args) {
        MinimumOperations min = new MinimumOperations();
        System.out.println(min.minimumOperations("2245047"));
    }

    /*
    * public static int minimumOperations(String num) {

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
    }*/
    public  int minimumOperations(String num) {
        //最多删除n次（变成0）
        int res = num.length();
        if (num.contains("0")) {
            res--;
        }
        //寻找 50 00 75 25结尾的数，找到它们对应的下标
        char[][] cs = {{'5', '0'},{'0', '0'}, {'7', '5'}, {'2', '5'}};
        for (int i = 0; i < cs.length; i++) {
            res = Math.min(res, deleteCnts(num, cs[i]));
        }
        return res;
    }

    public  int deleteCnts(String num, char[] targets) {
        char lastCh = targets[1];
        char nextCh = targets[0];
        int res = Integer.MAX_VALUE;
        int r = num.length()-1;
        while (r >= 0) {
            int t1 = r;
            while (t1 >= 0 && num.charAt(t1) != lastCh) {
                t1--;
            }
            if (t1 == -1) {
                //没找到
                return res;
            }
            //找下一个目标字符
            int t2 = t1 - 1;
            while (t2 >= 0 && num.charAt(t2) != nextCh) {
                t2--;
            }
            if (t2 == -1) {
                //没找到
                return res;
            }
            return num.length() - t2 - 2;
        }
        return res;
    }
}
