package com.zzc.exam;

import java.util.Arrays;

/**
 * @author zzc
 * @Description
 * @create 2022-12-19 9:53
 */
public class Demo05 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,6,2,7,3,8};
        minK(arr,4);
    }

    public static void minK(int[] arr,int k){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length-1 -i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        if(k >= arr.length){
            System.out.println(Arrays.toString(arr));
        }
        for (int i = 0; i < k; i++) {
            System.out.println(arr[i]);
        }
    }
}
