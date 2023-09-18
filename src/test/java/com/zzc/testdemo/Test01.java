package com.zzc.testdemo;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-10 9:10
 */
public class Test01 {
    @Test
    public void testPrint() {
        int a = 1;
        Integer b = 1;
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println("============================");
        int c = 128;
        Integer d = 128;
        System.out.println(System.identityHashCode(c));
        System.out.println(System.identityHashCode(d));

    }

    @Test
    public void testList() {
        List<String> z = List.of("z", "z", "c");
        //String collect = String.join("", z);
        String collect = z.stream().collect(Collectors.joining());
        System.out.println(collect);
    }

    @Test
    public void testList1() {
        List<String> z = List.of("z", "z", "c");
        StringBuilder res = new StringBuilder();
        for (String s : z) {
            res.append(s);
        }
        System.out.println(res);
    }

    @Test
    public void testList2() {
        List<String> z = List.of("z", "z", "c");
        String collect = String.join("", z);
        System.out.println(collect);
    }

    // 数组a[n] a[i] > 0 0 <= i <= j < n 求min(a[j]/a[i])
    @Test
    public void testQues() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(15) + 1;
        }
        System.out.println(Arrays.toString(arr));
        double[] res = new double[10];
        res[0] = 1;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            res[i] = Math.min(res[i-1], (double) arr[i] / max);
        }
        System.out.println(res[9]);
    }

    @Test
    public void testBitCount() {
        long start = System.currentTimeMillis();
        //System.out.println(Integer.bitCount(Integer.MAX_VALUE - 11));
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            //int bitCount = Integer.bitCount(i);
            int bitCount = numOfOne(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public int numOfOne(Integer n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    @Test
    public void testContain() {
        Set<String> set = Set.of("z", "x", "c");
        System.out.println(set.contains("z"));
    }

    @Test
    public void testArrayDeque() {
        /*List<Integer> deque = new ArrayList<>();
        deque.add(null);*/
        Queue<String> queue2 = new ArrayDeque<>();
        //queue2.add(null);
    }

    @Test
    public void testMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(null, 1);
        map.put(null, 2);
        System.out.println(map.get(null));
    }


    @Test
    public void replaceStr() {
        String str = "[[1,2],[4,2],[1,3],[5,2]]";
        String des = str.replace("[", "{").replace("]", "}");
        System.out.println(des);
    }
}
