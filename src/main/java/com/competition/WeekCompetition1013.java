package com.competition;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-10-13 10:34
 */
public class WeekCompetition1013 {

  @Test
  void testFun() {
    //TreeNode listNode = TreeNodeUtils.generate("ListNode", TreeNode.class, Integer.class);
    //System.out.println(kthLargestPerfectSubtree(listNode, 1));
    System.out.println(countWinningSequences("FWEFW"));
  }


  private static final int MOD = (int) 1e9 + 7;

  //TODO 没考虑积分为负数的情况！！！
  public int countWinningSequences(String s) {
    int n = s.length();
    //W E F: 0,1,2
    //dp[i][j][k]: 前i轮赢j积分 且最后一轮出牌为k
    long[][][] dp = new long[n][n + 2][3];
    char c = s.charAt(0);
    switch (c) {
      case 'F':
        dp[0][0][2] = 1;
        dp[0][1][0] = 1;
        break;
      case 'W':
        dp[0][0][0] = 1;
        dp[0][1][1] = 1;
        break;
      case 'E':
        dp[0][0][1] = 1;
        dp[0][1][2] = 1;
    }
    for (int i = 1; i < s.length(); i++) {
      char cur = s.charAt(i);
      //前i轮最多获取i + 1积分
      for (int j = i + 1; j >= 0; j--) {
        //考虑第i轮赢还是输
        switch (cur) {
          case 'F':
            //第i轮赢
            if (j - 1 >= 0) {
              dp[i][j][0] += (dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]) % MOD;
            }
            //第i轮输
            dp[i][j][1] += (dp[i - 1][j + 1][0] + dp[i - 1][j + 1][2]) % MOD;
            dp[i][j][2] += (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
            break;
          case 'W':
            //第i轮赢
            if (j - 1 >= 0) {
              dp[i][j][1] += (dp[i - 1][j - 1][0] + dp[i - 1][j - 1][2]) % MOD;
            }
            //第i轮输
            dp[i][j][2] += (dp[i - 1][j + 1][0] + dp[i - 1][j + 1][1]) % MOD;
            dp[i][j][0] += (dp[i - 1][j][1] + dp[i - 1][j][2]) % MOD;
            break;
          case 'E':
            //第i轮赢
            if (j - 1 >= 0) {
              dp[i][j][2] += (dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1]) % MOD;
            }
            //第i轮输
            dp[i][j][0] += (dp[i - 1][j + 1][1] + dp[i - 1][j + 1][2]) % MOD;
            dp[i][j][1] += (dp[i - 1][j][0] + dp[i - 1][j][2]) % MOD;
        }
      }
    }
    long res = 0;
    long[][] tmp = dp[n - 1];
    for (int i = 1; i < tmp.length; i++) {
      for (int j = 0; j < tmp[i].length; j++) {
        res = (res + tmp[i][j]) % MOD;
      }
    }
    return (int) res;
  }

  List<Integer> res;
  Map<TreeNode, Integer> map;

  public int kthLargestPerfectSubtree(TreeNode root, int k) {
    res = new ArrayList<>();
    map = new HashMap<>();
    dfs(root);
    if (res.size() < k) {
      return -1;
    }
    res.sort(Comparator.comparingInt(x -> -x));
    return res.get(k - 1);
  }

  //判断root节点是否是完美二叉树
  private int dfs(TreeNode root) {
    if (map.containsKey(root)) {
      return map.get(root);
    }
    if (root.left == null && root.right == null) {
      res.add(1);
      map.put(root, 1);
      return 1;
    }
    if (root.left == null || root.right == null) {
      map.put(root, -1);
      if (root.left != null) {
        dfs(root.left);
      }
      if (root.right != null) {
        dfs(root.right);
      }
      return -1;
    }
    int leftNode = dfs(root.left);
    int rightNode = dfs(root.right);
    int cnt = -1;
    if (leftNode == rightNode && leftNode != -1) {
      cnt = leftNode * 2 + 1;
    }
    res.add(cnt);
    map.put(root, cnt);
    return cnt;
  }

  public int[] findXSum(int[] nums, int k, int x) {
    int n = nums.length;
    int[] result = new int[n - k + 1];
    Map<Integer, Integer> cntMap = new HashMap<>();

    for (int i = 0; i < k; i++) {
      cntMap.put(nums[i], cntMap.getOrDefault(nums[i], 0) + 1);
    }
    result[0] = calculate(cntMap, x);
    for (int i = 1; i <= n - k; i++) {
      int first = nums[i - 1];
      cntMap.put(first, cntMap.get(first) - 1);
      if (cntMap.get(first) == 0) {
        cntMap.remove(first);
      }
      int last = nums[i + k - 1];
      cntMap.put(last, cntMap.getOrDefault(last, 0) + 1);
      result[i] = calculate(cntMap, x);
    }
    return result;
  }

  private int calculate(Map<Integer, Integer> cntMap, int x) {
    List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(cntMap.entrySet());
    entryList.sort((a, b) -> {
      if (!a.getValue().equals(b.getValue())) {
        return b.getValue() - a.getValue();
      } else {
        return b.getKey() - a.getKey();
      }
    });
    int res = 0;
    int count = 0;
    for (Map.Entry<Integer, Integer> entry : entryList) {
      res += entry.getKey() * entry.getValue();
      count++;
      if (count == x)
        break;
    }
    return res;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}