package com.competition;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-31 22:24
 */
public class WeekCompetition0831 {
  @Test
  void testFun() {
    //int[] damage = {80,79};
    int[] damage = {1, 2, 3, 4};
    //int[] health = {86,13};
    int[] health = {4, 5, 6, 8};
    System.out.println(minDamage(4, damage, health));
  }

  @Test
  void testFunV1() {
    //System.out.println(generate("58800"));
    System.out.println(countGoodIntegers(5, 6));
  }

  // 主函数，计算长度为 n 的所有 "好整数"

  // 回溯函数
  public long countGoodIntegers(int n, int k) {
    Set<String> set = new HashSet<>();
    long res = 0;
    int count = 0;
    // 分奇数和偶数长度分别处理回文数生成
    if (n == 1) { // 特殊情况：1位数
      for (int i = 1; i <= 9; i++) {
        if (i % k == 0) {
          if (!set.contains(i)) {
            set.add(String.valueOf(i));
            res++;
          }
          count++;
        }
      }
    } else {
      // 生成 n 位长度的回文数
      if (n % 2 == 0) { // 偶数长度
        int halfLength = n / 2;
        int start = (int) Math.pow(10, halfLength - 1);
        int end = (int) Math.pow(10, halfLength) - 1;
        for (int i = start; i <= end; i++) {
          String firstHalf = Integer.toString(i);
          String palindrome = firstHalf + new StringBuilder(firstHalf).reverse().toString();
          char[] chars = palindrome.toCharArray();
          Arrays.sort(chars);
          String s = new String(chars);
          long palinNum = Long.parseLong(palindrome);
          if (palinNum % k == 0) {
            if (!set.contains(s)) {
              set.add(s);
              //生成排列
              res +=generate(s);
            }
            count++;
          }
        }
      } else { // 奇数长度
        int halfLength = (n + 1) / 2;
        int start = (int) Math.pow(10, halfLength - 1);
        int end = (int) Math.pow(10, halfLength) - 1;
        for (int i = start; i <= end; i++) {
          String firstHalf = Integer.toString(i);
          String palindrome = firstHalf + new StringBuilder(firstHalf).reverse().substring(1);
          char[] chars = palindrome.toCharArray();
          Arrays.sort(chars);
          String s = new String(chars);
          long palinNum = Long.parseLong(palindrome);
          if (palinNum % k == 0) {
            if (!set.contains(s)) {
              set.add(s);
              //生成排列
              res +=generate(s);
            }
            count++;
          }
        }
      }
    }
    System.out.println(set);
    return res;
  }

  private long generate(String s) {
    int[] cnts = new int[10];
    //统计每个字符出现的次数
    for (int i = 0; i < s.length(); i++) {
      cnts[s.charAt(i) - '0']++;
    }
    long qitawei = quanPaiLie(s.length());
    long fenmu = 1L;
    for (int i = 0; i < cnts.length; i++) {
      fenmu = fenmu * quanPaiLie(cnts[i]);
    }
    if (cnts[0] >= 1) {
      return (qitawei) / fenmu - (quanPaiLie(s.length() - 1)) / (fenmu / quanPaiLie(cnts[0]) * quanPaiLie(cnts[0] - 1));
    }
    return (qitawei) / fenmu;
  }

  //阶乘
  private long quanPaiLie(int n) {
    if (n == -1 ) {
      return 0;
    }
    if (n == 1 || n == 0) {
      return 1;
    }
    return n * quanPaiLie(n - 1);
  }

  public long minDamage(int power, int[] damage, int[] health) {
    long res = 0L;
    //求总的伤害和
    long sum = 0L;

    //先攻击伤害最高的 2: 表示需要攻击的次数
    int[][] tmp = new int[damage.length][3];
    for (int i = 0; i < tmp.length; i++) {
      sum += damage[i];
      int cnt = (health[i] + power - 1) / power;
      tmp[i] = new int[]{damage[i], health[i], cnt};
    }
    final long finalSum = sum;
    //damage降序排列
    Arrays.sort(tmp, (a, b) -> {
      int aCnt = a[2];
      int bCnt = b[2];
      //攻击a时受到的伤害
      long da = b[0];
      long db = a[0];
      long tmp1 = aCnt * (da);
      if (aCnt * (da) == bCnt * db) {
        if (a[0] == b[0]) {
          //health升序
          return a[1] - b[1];
        }
        return b[0] - a[0];
      }
      return Long.compare(aCnt * (da), bCnt * db);

    });
    //damage后缀和
    long[] suffix = new long[tmp.length];
    suffix[suffix.length - 1] = tmp[suffix.length - 1][0];
    for (int i = suffix.length - 2; i >= 0; i--) {
      suffix[i] = tmp[i][0] + suffix[i + 1];
    }
    for (int i = 0; i < tmp.length; i++) {
      int h = tmp[i][1];
      int cnt = (h + power - 1) / power;
      res += cnt * suffix[i];
    }
    return res;
  }

  public String stringHash(String s, int k) {
    int n = s.length();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i += k) {
      int hashSum = 0;

      for (int j = i; j < i + k; j++) {
        hashSum += s.charAt(j) - 'a';
      }

      char hashedChar = (char) ((hashSum % 26) + 'a');
      sb.append(hashedChar);
    }

    return sb.toString();
  }

  public int generateKey(int num1, int num2, int num3) {

    String str1 = String.format("%04d", num1);
    String str2 = String.format("%04d", num2);
    String str3 = String.format("%04d", num3);

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < 4; i++) {
      char minChar = (char) Math.min(Math.min(str1.charAt(i), str2.charAt(i)), str3.charAt(i));
      result.append(minChar);
    }
    return Integer.parseInt(result.toString());
  }
}
