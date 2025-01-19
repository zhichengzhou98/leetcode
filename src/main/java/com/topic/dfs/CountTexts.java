package com.topic.dfs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description 2266. 统计打字方案数 dfs
 * @create 2025-01-19 10:45
 */
public class CountTexts {
  @Test
  void testFun() {
    System.out.println(countTexts("222222222222222222222222222222222222"));
  }

  static Set<String> set = new HashSet<>();

  static {
    for (int i = 2; i <= 9; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 1; j <= 3; j++) {
        sb.append(i + "");
        set.add(sb.toString());
      }
    }
    set.add("7777");
    set.add("9999");
  }

  public static int MOD = (int) (1E9 + 7);
  public String str;

  long[] memo;

  public int countTexts(String pressedKeys) {
    memo = new long[100001];
    Arrays.fill(memo, -1L);
    this.str = pressedKeys;
    return (int) dfs(pressedKeys.length() - 1);
  }

  private long dfs(int index) {
    if (index <= 0) {
      return 1;
    }

    if (memo[index] != -1) {
      return memo[index];
    }
    long res = (dfs(index - 1)) % MOD;
    if (set.contains(str.substring(index - 1, index + 1))) {
      res += (dfs(index - 2)) % MOD;
      if (index - 2 >= 0 && set.contains(str.substring(index - 2, index + 1))) {
        res += (dfs(index - 3)) % MOD;
        if (index - 3 >= 0 && set.contains(str.substring(index - 3,index + 1))) {
          res += (dfs(index - 4)) % MOD ;
        }
      }
    }
    memo[index] = res;
    return res % MOD;
  }
}
