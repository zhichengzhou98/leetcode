package com.zzc.lambda;

import java.util.Arrays;

/**
 * @author zzc
 * @Description
 * @create 2023-03-19 15:41
 */
public class TestLambda {
    public static void main(String[] args) {
        //int mathNum = 10;
        System.out.println(getSum((arr) -> Arrays.stream(arr).sum(), new int[]{1, 1, 1}));
    }

    public static int getSum(SumFunc sumFunc,int[] arr) {

        return sumFunc.sum(arr);
    }


}
