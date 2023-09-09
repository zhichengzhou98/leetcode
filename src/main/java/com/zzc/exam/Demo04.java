package com.zzc.exam;

import java.util.Arrays;

/**
 * @author zzc
 * @Description 冒泡排序
 * @create 2022-12-15 15:50
 */
public class Demo04 {
    public static void main(String[] args) {
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 30);
        }
        System.out.println(Arrays.toString(arr));
        bubble(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void bubble(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j+1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

