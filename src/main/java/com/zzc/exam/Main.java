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
        int cy = Integer.parseInt(s[0]);//采样人员数
        int zyz = Integer.parseInt(s[1]);//志愿者人数
        String s1 = scanner.nextLine();
        String[] s2 = s1.split(" ");
        Integer[] cyxl = new Integer[s2.length];//采用人员效率
        for (int i = 0; i < s2.length; i++) {
            cyxl[i] = Integer.parseInt(s2[i]);
        }
        Arrays.sort(cyxl);//将采样效率排序
        if(cy == 1){
            //只有一个采样员
            if(zyz == 0){
                System.out.println(cyxl[0] - 0.2*cyxl[0]);
            }
            if(zyz == 1){
                System.out.println(cyxl[0]);
            }else if(zyz <=4){
                System.out.println(cyxl[0] + (zyz - 1)*cyxl[0]*0.1);
            }else {
                System.out.println(1.3*cyxl[0]);
            }
        }
        List<int[]> list = new ArrayList<>();//链表每个元素代表一组采样员与志愿者
        for (int i = 0; i < cyxl.length; i++) {
            int[] ints1 = new int[2];
            ints1[0] = cyxl[cyxl.length-1-i];
            list.add(ints1);
        }
        int i = 0;
        int j = 1;
        while (true){
            if(j>=list.size()){
                while (i < list.size()){
                    if(zyz == 0){
                        break;
                    }
                    int[] ints = list.get(i);
                    int anInt = ints[1];
                    if(anInt == 4){
                        i++;
                    }else {
                        int sy = 4- anInt;
                        if(zyz <= sy ){
                            ints[1] = zyz + anInt;
                            zyz = 0;
                        }else {
                            ints[1] = 4;
                            zyz =zyz-anInt;
                        }
                    }
                }

                break;
            }
            if(zyz == 0){
                break;
            }
            int[] group1 = list.get(i);
            int[] group2 = list.get(j);
            int cyx1 = group1[0];
            int zyz1 = group1[1];
            int cyx2 = group2[0];
            int zyz2 = group2[1];
            if(zyz1 == 4){
                i++;
                if(j == i){
                    j++;
                }
                break;
            }
            if(cyx1 >= 2 * cyx2){

                int sy = 4 - zyz1;
                //志愿者优先全分给采样员1
                if(zyz <= sy ){
                    group1[1] = zyz + zyz1;
                    zyz = 0;
                }else {
                    group1[1] = 4;
                    zyz =zyz-zyz1;
                }
            }else {
                group1[1] = group1[1] + 1;
                zyz = zyz - 1;
                if(zyz ==0){
                    return;
                }else {
                    group2[1] = group2[1] + 1;
                    zyz = zyz - 1;
                    j++;
                }
            }
        }
        double res = 0;
        for (int[] ints : list) {
            double v = tongJi(ints);
            res += v;
        }
        System.out.println((int)res);
    }

    //统计每组核酸检测效率
    public static double tongJi(int[] group){
        int zyz = group[1];
        int cyxl = group[0];
        if(zyz == 0){
            return cyxl - 0.2 * cyxl;
        }else if(zyz == 1){

            return cyxl;
        }else if(zyz <=4){
            return (cyxl+ (zyz - 1)*cyxl*0.1);
        }else {
            return 1.3*cyxl;
        }
    }

}
