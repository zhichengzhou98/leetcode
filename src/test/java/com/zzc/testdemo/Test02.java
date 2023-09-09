package com.zzc.testdemo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-01 12:23
 */
public class Test02 {


        public static void main(String[] args) {
            int[] intArray = {5, 2, 9, 1, 5, 6, 3};

            // 使用自定义排序进行排序
            //Arrays.sort(intArray, new CustomComparator());

            // 打印排序结果
            for (int num : intArray) {
                System.out.print(num + " ");
            }
        }

    // 自定义Comparator实现

}

class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer num1, Integer num2) {
        // 这里可以定义自己的排序逻辑，返回负数表示num1在前，返回正数表示num2在前，返回0表示相等
        // 例如，按照数字的绝对值进行排序
        return Integer.compare(Math.abs(num1), Math.abs(num2));
    }
}
