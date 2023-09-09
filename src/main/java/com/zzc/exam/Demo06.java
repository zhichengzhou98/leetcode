package com.zzc.exam;

/**
 * @author zzc
 * @Description
 * @create 2022-12-19 15:13
 */
public class Demo06 {
    public static void main(String[] args) {
        System.out.println(merge(new int[]{1,4},new int[]{2,4,6,7}));
    }

    public static double merge(int[] arr1,int[] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] res = new int[len1+len2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (true){
            if(i==len1){
                while (j<len2){
                    res[k] = arr2[j];
                    k++;
                    j++;
                }
                break;
            }else if(j==len2){
                while (i<len1){
                    res[k] = arr2[i];
                    k++;
                    i++;
                }
                break;
            }
            if(arr1[i]<arr2[j]){
                res[k] = arr1[i];
                i++;
                k++;
            }else {
                res[k] = arr2[j];
                j++;
                k++;
            }
            if(k == res.length){
                break;
            }
        }
        if(k%2==0){
            return (res[k/2] + res[k/2-1])/2;
        }else {
            return res[k/2];
        }
    }
}
