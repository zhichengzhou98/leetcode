package com.zzc.exam;

import java.util.*;


/**
 * @author zzc
 * @Description
 * @create 2022-12-13 23:01
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String peopleNum = scanner.nextLine();
        String[] s = peopleNum.split(" ");
        int zyz = Integer.parseInt(s[1]);//志愿者人数
        String s1 = scanner.nextLine();
        String[] s2 = s1.split(" ");
        Integer[] cyxl = new Integer[s2.length];//采用人员效率
        for (int i = 0; i < s2.length; i++) {
            cyxl[i] = Integer.parseInt(s2[i]);
        }

        List<Double> list = new ArrayList<>();
        //遍历采样效率
        double sum = 0;
        for (int i = 0; i < cyxl.length; i++) {
            sum += cyxl[i] * 0.8;
            list.add(0.2 * cyxl[i]);
            list.add(0.1 * cyxl[i]);
            list.add(0.1 * cyxl[i]);
            list.add(0.1 * cyxl[i]);
        }
        list.sort(Double::compareTo);
        int j = list.size() - 1;
        while (j >= 0 && zyz > 0) {
            sum += list.get(j);
            j--;
            zyz--;
        }
        System.out.println((int) sum);
    }

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String peopleNum = scanner.nextLine();
        String[] s = peopleNum.split(" ");
        int cy = Integer.parseInt(s[0]);//采样人员数
        int zyz = Integer.parseInt(s[1]);//志愿者人数
        String s1 = scanner.nextLine();
        String[] s2 = s1.split(" ");
        Integer[] cyxl = new Integer[s2.length];//采用人员效率
        for (int i = 0; i < s2.length; i++) {
            cyxl[i] = Integer.parseInt(s2[i]);
        }
        //最大堆
        Queue<Double> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> -a));
        //遍历采样效率
        double sum = 0;
        for (int i = 0; i < cyxl.length; i++) {
            sum += cyxl[i] * 0.8;
            pq.offer(0.2 * cyxl[i]);
            pq.offer(0.1 * cyxl[i]);
            pq.offer(0.1 * cyxl[i]);
            pq.offer(0.1 * cyxl[i]);
        }
        while (!pq.isEmpty() && zyz > 0) {
            sum += pq.poll();
            zyz--;
        }

        System.out.println((int) sum);
    }*/
}
