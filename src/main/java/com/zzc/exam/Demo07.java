package com.zzc.exam;

/**
 * @author zzc
 * @Description
 * @create 2022-12-21 14:28
 */
public class Demo07 {
    public static void main(String[] args) {
        System.out.println(max(new int[]{2,7,9,3,1}));
    }

    public static int max(int[] arr){
        if(arr.length==1){
            return arr[0];
        }
        if(arr.length==2){
            return Math.max(arr[0],arr[1]);
        }

        int[] res = new int[arr.length];
        res[0] = arr[0];
        res[1] = Math.max(arr[0],arr[1]);
        for (int i = 2; i < arr.length; i++) {
            res[i] = Math.max(res[i-2] + arr[i],res[i-1]);
        }
        return res[arr.length-1];
    }
}
