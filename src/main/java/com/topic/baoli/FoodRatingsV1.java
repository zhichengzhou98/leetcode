package com.topic.baoli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description [2353]设计食物评分系统 排序超时
 * @create 2025-02-28 14:54
 */
public class FoodRatingsV1 {
  public static void main(String[] args) {
    String[] arrays = new String[]{"a", "c", "b"};
    List<String> list = Arrays.stream(arrays).sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());
    System.out.println(list);
  }

  // 食物 分数
  Map<String, Integer> foodRate;
  // 烹饪方式 食物列表
  Map<String, List<String>> cuisineFoods;

  public FoodRatingsV1(String[] foods, String[] cuisines, int[] ratings) {
    foodRate = new HashMap<>();
    cuisineFoods = new HashMap<>();
    for (int i = 0; i < foods.length; i++) {
      foodRate.put(foods[i], ratings[i]);
      if (cuisineFoods.containsKey(cuisines[i])) {
        cuisineFoods.get(cuisines[i]).add(foods[i]);
      } else {
        List<String> list = new ArrayList<>();
        list.add(foods[i]);
        cuisineFoods.put(cuisines[i], list);
      }
    }
  }

  public void changeRating(String food, int newRating) {
    foodRate.put(food, newRating);
  }

  // 超时 n * n log n
  public String highestRated(String cuisine) {
    List<String> list = cuisineFoods.get(cuisine);
    return list.stream().sorted((a, b) -> {
      int a1 = foodRate.get(a);
      int b1 = foodRate.get(b);
      if (a1 == b1) {
        return a.compareTo(b);
      }
      return b1 - a1;
    }).findFirst().get();
  }
}
