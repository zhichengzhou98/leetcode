package com.zzc.exam;

import java.util.Arrays;

/**
 * @author zzc
 * @Description
 * @create 2023-02-18 10:22
 */
public class Demo08 {
    public static void main(String[] args) {
        //nums = [1,3,-1,-3,5,3,6,7], k = 3
        System.out.println(Arrays.toString(test(new int[]{1,3,-1,-3,5,3,6,7,9,3,12,52,235,12,21,124,345636,242,6546},3)));
    }

    public static int[] test(int[] arr,int k){
        int[] arr1 = new int[k];
        int[] res = new int[arr.length -k +1];
        for (int j = 0;j < res.length;j++){
            for (int i = j;i < k+j;i++){
                arr1[i-j] = arr[i];
            }
            res[j] = max(arr1);
        }
        return res;
    }

    public static int max(int[] arr){
        int max = arr[0];
        if(arr.length >= 2){
            for (int i = 1;i < arr.length;i++){
                if(arr[i]>=max){
                    max = arr[i];
                }
            }
        }
        return max;
    }
}
