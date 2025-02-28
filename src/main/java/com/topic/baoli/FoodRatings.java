package com.topic.baoli;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author zc.zhou
 * @Description [2353]设计食物评分系统 使用treeMap n * logn
 * @create 2025-02-28 17:15
 */
public class FoodRatings {
  // 食物 分数
  Map<String, Integer> foodRate;
  // 食物 烹饪方式
  Map<String, String> foodCui;
  // 烹饪方式 食物列表 PairV1 为分数和名字
  Map<String, TreeMap<PairV1, String>> cuisineFoods;

  public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
    foodCui = new HashMap<>();
    foodRate = new HashMap<>();
    cuisineFoods = new HashMap<>();
    for (int i = 0; i < foods.length; i++) {
      foodCui.put(foods[i], cuisines[i]);
      foodRate.put(foods[i], ratings[i]);
      if (cuisineFoods.containsKey(cuisines[i])) {
        cuisineFoods.get(cuisines[i]).put(new PairV1(ratings[i], foods[i]), foods[i]);
      } else {
        TreeMap<PairV1, String> treeMap = new TreeMap<>((a, b) -> {
          if (a.score == b.score) {
            return a.name.compareTo(b.name);
          }
          return b.score - a.score;
        });
        treeMap.put(new PairV1(ratings[i], foods[i]), foods[i]);
        cuisineFoods.put(cuisines[i], treeMap);
      }
    }
  }

  public void changeRating(String food, int newRating) {
    String cui = foodCui.get(food);
    // update cuisineFoods
    TreeMap<PairV1, String> treeMap = cuisineFoods.get(cui);
    Integer rate = foodRate.get(food);
    treeMap.remove(new PairV1(rate, food));
    treeMap.put(new PairV1(newRating, food),food);

    foodRate.put(food, newRating);
  }

  // 超时 n * n log n
  public String highestRated(String cuisine) {
    return cuisineFoods.get(cuisine).firstEntry().getValue();
  }
}
class PairV1 {
  int score;
  String name;

  public PairV1(int score, String name) {
    this.score = score;
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    PairV1 pairV1 = (PairV1) o;
    return score == pairV1.score && Objects.equals(name, pairV1.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(score, name);
  }
}
