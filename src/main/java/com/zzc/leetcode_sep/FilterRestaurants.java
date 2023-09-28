package com.zzc.leetcode_sep;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-27 8:39
 */
public class FilterRestaurants {
    public static void main(String[] args) {

    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> collect = Arrays.stream(restaurants).filter(arr -> (veganFriendly != 1 || arr[2] == 1) && arr[3] <= maxPrice && arr[4] <= maxDistance)
                .sorted((a, b) -> {
                    if (b[1] == a[1]) {
                        return b[0] - a[0];
                    }
                    return b[1] - a[1];
                }).map(a -> a[0]).collect(Collectors.toList());
        return collect;
    }
}
