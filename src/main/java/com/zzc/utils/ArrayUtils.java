package com.zzc.utils;

import com.zzc.leetcode_aug.FindKthLargest;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-27 17:58
 */
public class ArrayUtils {

    public static void main(String[] args) {
        int[][] generate = generate(int[][].class);
        //int[] generate = generate(int[].class);
        System.out.println(Arrays.toString(generate));
    }

    public static <T> T generate(Class type1) {
        Properties properties = new Properties();
        InputStream stream = ArrayUtils.class.getClassLoader().getResourceAsStream("testCase.properties");
        try {
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String arrayStr = (String) properties.get("array");
        // 获取泛型类型的 Class 对象
        if (int[][].class.equals(type1)) {
            //转成二维数组 去掉首尾 [ ]
            String substring = arrayStr.substring(1, arrayStr.length() - 1);
            //substring 按逗号分隔
            String[] arrays = substring.replace("],[", "];[").split(";");

            int[][] array = Arrays.stream(arrays).map(arr -> {
                //去掉首尾 [ ]
                String substring1 = arr.substring(1, arr.length() - 1);
                String[] split = substring1.split(",");
                return Arrays.stream(split).map(Integer::parseInt).mapToInt(Integer::intValue).toArray();
            }).toArray(int[][]::new);
            return (T) array;
        }else if (int[].class.equals(type1)) {
            //转一维数组
            String[] split = arrayStr.substring(1, arrayStr.length() - 1).split(",");
            int[] array = Arrays.stream(split).map(Integer::parseInt).mapToInt(Integer::intValue).toArray();
            return (T)array;
        }

        return null;
    }
}
