package com.zzc.weekcompetition;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-16 22:30
 */
public class MinimumRightShifts {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,4};
        System.out.println(minimumRightShifts(Arrays.stream(arr).boxed().collect(Collectors.toList())));
    }
    public static int minimumRightShifts(List<Integer> nums) {
        int res = 0;
        List<Integer> sortedList = nums.stream().sorted().collect(Collectors.toList());

        Integer first = sortedList.get(0);
        for (int j = 0; j < nums.size(); j++) {
            while (nums.get(j) != first.intValue()) {
                j++;
            }
            res = j;
            break;
        }

        for (int i = 0; i < sortedList.size(); i++) {
            if (sortedList.get(i).intValue() != nums.get((i + res) % nums.size())) {
                return -1;
            }
        }

        return (nums.size() - res) % nums.size();
    }
}
