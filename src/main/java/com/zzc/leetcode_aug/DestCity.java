package com.zzc.leetcode_aug;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-14 20:25
 */
public class DestCity {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Set<String> set = Set.of("z", "x", "c");
        System.out.println(set.contains("z"));
    }
    public String destCity(List<List<String>> paths) {
        Set<String> startCity = paths.stream().map(path -> path.get(0)).collect(Collectors.toSet());

        return paths.stream().filter(p -> !startCity.contains(p.get(1))).findFirst().get().get(1);

    }
    
}
