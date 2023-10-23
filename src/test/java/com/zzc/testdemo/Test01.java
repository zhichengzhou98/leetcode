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
        String str = "[[31,28,33,0,8,57,86,99,23,98],[25,90,20,73,34,65,29,9,42,46],[17,84,10,4,40,5,41,21,71,79],[13,70,69,81,63,93,77,1,94,53],[38,87,61,50,92,2,15,95,82,68],[44,72,88,47,27,91,37,48,83,16],[3,30,96,66,7,58,76,54,19,64],[85,45,60,11,51,26,6,22,74,32],[43,12,62,59,89,52,36,97,49,78],[75,24,14,67,56,35,55,39,80,18]]";
        String des = str.replace("[", "{").replace("]", "}");
        System.out.println(des);
    }

    @Test
    public void setRemove() {
        Set<Integer> des = new HashSet<>(Set.of(1));
        des.remove(1);
        for (int i :des) {
            System.out.println(i);
        }
        System.out.println(des);
    }

    @Test
    public void test2() {
        ArrayList<Integer> res = new ArrayList<>(List.of(4, 1, 2));
        int n = 7;
        long cnt = 0L;
        for (int i = 1; i < res.size(); i++) {
            Integer pre = res.get(i - 1);
            n = n - pre;
            cnt = cnt + (long)pre * n;
        }
        System.out.println(cnt);
    }



}
