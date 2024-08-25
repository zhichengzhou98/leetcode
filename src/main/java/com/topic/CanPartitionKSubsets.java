package com.topic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-25 16:26
 */
public class CanPartitionKSubsets {
  @Test
  void testFun() {
    int[] arr = {4,4,6,2,3,8,10,2,10,7};
    System.out.println(canPartitionKSubsets(arr, 4));
  }

  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = 0;
    int max = nums[0];
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      sum += num;
      max = Math.max(max, num);
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    if (sum % k != 0) {
      return false;
    }
    int sum1 = sum / k;
    if (max > sum1) {
      return false;
    }
    return dfs(map, sum1);
  }

  public boolean dfs(Map<Integer, Integer> map, int target) {
    List<Integer> list = map.keySet().stream().sorted().toList();
    if (list.isEmpty() ||list.size() == 0) {
      return true;
    }
    int temp = list.get(0);
    remove(map, temp);
    if (temp == target) {
      //递归
      return dfs(map, target);
    } else if (temp > target) {
      return false;
    }else {
      if (map.containsKey(target - temp)) {
        remove(map, target - temp);
        return dfs(map, target);
      } else {
        for (int i = 1; i < list.size(); i++) {
          int num = list.get(i);
          remove(map, num);
          temp += num;
          if (temp > target) {
            return false;
          }else if (temp == target) {
            return dfs(map, target);
          }else if (map.containsKey(target -temp)){
            remove(map,target - temp);
            return dfs(map, target);
          }
        }
        return false;
      }
    }
  }

  private void remove(Map<Integer, Integer> map, int temp) {
    map.put(temp, map.get(temp) - 1);
    if (map.get(temp) == 0) {
      map.remove(temp);
    }
  }

  public boolean canPartitionKSubsetsV1(int[] nums, int k) {
    int sum = 0;
    int max = nums[0];
    for (int num : nums) {
      sum += num;
      max = Math.max(max, num);
    }
    if (sum % k != 0) {
      return false;
    }
    int sum1 = sum / k;
    if (max > sum1) {
      return false;
    }
    Arrays.sort(nums);
    int left = 0;

    int right = nums.length - 1;
    while (right > 0 && nums[right] == sum1) {
      right--;
    }
    while (right > left) {
      int tempSum = nums[right];
      while (right > 1 && tempSum + nums[right - 1] <= sum1) {
        right--;
        tempSum += nums[right];
      }
      if (tempSum < sum1) {
        //将left向右移动
        tempSum += nums[left];
        if (tempSum > sum1) {
          return false;
        } else if (tempSum == sum1) {
          right--;
          left++;
          continue;
        }
        while (left + 1 < right && tempSum + nums[left + 1] <= sum1) {
          left++;
          tempSum += nums[left];
        }
        if (tempSum < sum1) {
          return false;
        }
      }
      right--;
      left++;
    }
    return true;
  }
}
