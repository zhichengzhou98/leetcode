package com.zzc.weekcompetition;

import java.util.Arrays;
import java.util.zip.ZipEntry;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-02 23:10
 */
public class CountKSubsequencesWithMaxBeauty {
    public static void main(String[] args) {
        /*System.out.println(countKSubsequencesWithMaxBeauty("abbcd", 4));
        System.out.println(countKSubsequencesWithMaxBeauty("bcca", 2));
        System.out.println(countKSubsequencesWithMaxBeauty("dfyq", 2));
        System.out.println(countKSubsequencesWithMaxBeauty("fkp", 2));
        System.out.println(countKSubsequencesWithMaxBeauty("minc", 3));
        System.out.println(countKSubsequencesWithMaxBeauty("bqzowoi", 3));*/
        System.out.println(countKSubsequencesWithMaxBeauty("ffcsdqcnkr", 2));
    }
    public static int countKSubsequencesWithMaxBeauty(String s, int k) {
        if (k > 26) {
            return 0;
        }
        //统计s中每个字符出现的次数
        int[] cnts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
        }
        Integer[] array = Arrays.stream(cnts).boxed().toArray(Integer[]::new);
        //将cnts降序排列
        Arrays.sort(array, (a,b)->(b - a));
        //取前k个，后面可能与第k - 1个值相等
        //统计与第0相等的个数

        int dul = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[k-1].intValue()) {
                dul++;
            }
        }

        //与k-1相等的数一共有dul个（包括k-1）
        //计算出要从k-1中取出的个数
        int num = k;
        for (int i = 0; i < array.length; i++) {
            if (array[i].intValue() > array[k-1]) {
                num--;
            }else {
                break;
            }
        }
        double res= 1;
        //先去 k-num 个，再从dul中取num个
        for (int i = 0; i <= k -num-1 ; i++) {
            res = (res * array[i]) % (Math.pow(10, 9) + 7);
        }
        double a =  1.0;
        for (int i = 1; i <= num; i++) {
            a = a * array[k-1]% (Math.pow(10, 9) + 7);
        }
        double zeHe = (zuHe(dul, num) * a % (Math.pow(10, 9) + 7));
        res = res * zeHe % (Math.pow(10, 9) + 7);
        return (int) res;
    }

    public static double zuHe(int dul, int num) {
        double a = 1.0;
        double b = dul;
        for (int i = 1; i <= num; i++) {
            a = a * i;
        }
        for (int i = 1; i < num; i++) {
            b = b * (dul - i);
        }
        return  b / a % (Math.pow(10, 9) + 7);
    }
}
