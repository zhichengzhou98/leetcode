package com.topic.greedy;

/**
 * @author zc.zhou
 * @Description 134. 加油站
 * @create 2024-10-06 09:39
 */
public class CanCompleteCircuit {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int totalTank = 0; // 总的油量
    int currentTank = 0; // 当前油量
    int startIndex = 0; // 出发的加油站索引

    for (int i = 0; i < gas.length; i++) {
      totalTank += gas[i] - cost[i]; // 计算总油量
      currentTank += gas[i] - cost[i]; // 计算当前油量

      // 如果当前油量小于0，无法从 startIndex 到 i
      if (currentTank < 0) {
        startIndex = i + 1; // 从下一个加油站开始
        currentTank = 0; // 重置当前油量
      }
    }
    // 如果总油量大于等于0，则存在解
    return totalTank >= 0 ? startIndex : -1;
  }
}
