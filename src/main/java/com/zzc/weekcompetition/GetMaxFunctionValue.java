package com.zzc.weekcompetition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zc.zhou
 * @Description 2836. 在传球游戏中最大化函数值
 * @create 2023-08-27 16:07
 */
public class GetMaxFunctionValue {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(0);
        list.add(1);
        GetMaxFunctionValue getMaxFunctionValue = new GetMaxFunctionValue();
        System.out.println(getMaxFunctionValue.getMaxFunctionValue(list,4));
    }
    public long getMaxFunctionValue(List<Integer> receiver, long k) {

        //记录每个点传到自己所传球的次数 及 下标总和
        long[][] temp = new long[receiver.size()][];
        for (int i = 0; i < receiver.size(); i++) {
            temp[i] = getCounts(i, receiver, receiver.size());
        }
        long[] res = new long[receiver.size()];
        for (int i = 0; i < res.length; i++) {
            long[] countAndSum = temp[i];
            long count = countAndSum[0];
            long sum = countAndSum[1];

            res[i] = ( k  / count) * sum + getCounts(receiver.get(i), receiver, k % count)[1];
        }
        return Arrays.stream(res).max().getAsLong();
    }

    private long[] getCounts(int i, List<Integer> receiver, long k) {
        if (k == 0 ){
            return new long[]{0, i};
        }
        int count = i;
        int num = 0;
        long[] res = new long[2];
        res[0] = num;
        int j = i;
        boolean flag = false;
        while (k > 0) {
            i = receiver.get(i);
            if (i == j && !flag) {
                res[0] = num;
                flag = true;
            }else {
                num++;
            }
            count += i;
            k--;

        }
        res[1] = count;
        return res;

    }
}
