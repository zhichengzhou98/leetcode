package com.topic.baoli;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-18 11:00
 */
public class LargestPalindrome {
  @Test
  void testFun() {
    System.out.println(largestPalindrome(8, 7));
    //999999959999999 99999977999999 9999997999999 999999999999 99999499999 9999449999 999969999 99944999
    // 9994999 999999 99799
    // 9779 959
    //divBy7(1000000000000000L);
  }

  public void divBy7(long n) {
    for (long i = n; i > 0 ; i--) {
      if (i % 7 == 0) {
        String s1 = String.valueOf(i);
        String s2 = new StringBuilder(s1).reverse().toString();
        if(s1.equals(s2)) {
          System.out.println(i);
        }
      }
    }
  }

  public String largestPalindrome(int n, int k) {
    StringBuilder sb = new StringBuilder();
    if (k == 1 || k == 9 || k == 3) {
      for (int i = 0; i < n; i++) {
        sb.append('9');
      }
      return sb.toString();
    }
    if (k == 2) {
      //首位 末尾都是8
      if (n == 1) {
        return "8";
      }
      for (int i = 0; i < n - 2; i++) {
        sb.append('9');
      }
      return "8" + sb + "8";
    }
    if (k == 4) {
      if (n <= 3) {
        for (int i = 0; i < n; i++) {
          sb.append('8');
        }
        return sb.toString();
      }
      //"8888"
      for (int i = 0; i < n - 4; i++) {
        sb.append('9');
      }
      return "88" + sb + "88";
    }
    if (k == 5) {
      if (n <= 2) {
        for (int i = 0; i < n; i++) {
          sb.append('5');
        }
        return sb.toString();
      }
      for (int i = 0; i < n - 2; i++) {
        sb.append('9');
      }
      return "5" + sb + "5";
    }
    if (k == 6) {
      if (n <= 2) {
        for (int i = 0; i < n; i++) {
          sb.append('6');
        }
        return sb.toString();
      } else if (n == 3) {
        return "888";
      } else {
        //n >= 4
        if (n % 2 == 0) {
          for (int i = 0; i < n / 2 - 2; i++) {
            sb.append('9');
          }
          sb = new StringBuilder("8" + sb + "7");
          StringBuilder sb1 = new StringBuilder(sb);
          String rev = sb1.reverse().toString();
          return sb + rev;
        } else {
          for (int i = 0; i < (n - 1) / 2 - 1; i++) {
            sb.append('9');
          }
          sb = new StringBuilder("8" + sb);
          StringBuilder sb1 = new StringBuilder(sb);
          String rev = sb1.reverse().toString();
          return sb + "8" + rev;
        }
      }
    }
    if (k == 8) {
      if (n <= 6) {
        for (int i = 0; i < n; i++) {
          sb.append('8');
        }
        return sb.toString();
      }
      for (int i = 0; i < n - 6; i++) {
        sb.append('9');
      }
      return "888" + sb + "888";
    }
    if (k == 7) {
      if (n == 1) {
        return "7";
      }else if (n == 2) {
        return "77";
      }else if (n == 3) {
        return "959";
      }
      if (n % 2 == 1) {
        //n为奇数 枚举中间一位数字
        for (int i = 0; i < (n - 1) / 2; i++) {
          sb.append('9');
        }
        for (int i = 9; i >= 0 ; i--) {
          StringBuilder sb1 = new StringBuilder(sb).reverse().append(i);
          String res = sb1.toString() + sb;
          if (check(res)) {
            return res;
          }
        }
      } else {
        //将n/2 枚举最后一位
        for (int i = 0; i < (n) / 2 - 1; i++) {
          sb.append('9');
        }
        for (int i = 9; i >= 0 ; i--) {
          StringBuilder sb1 = new StringBuilder(sb).append(i);
          StringBuilder sb2 = new StringBuilder(sb1).reverse();
          String res = sb1.toString()+sb2;
          if (check(res)) {
            return res;
          }
        }
      }
    }
    return "";
  }

  public boolean check(String s) {
    BigInteger bigDecimal = new BigInteger(s);
    return bigDecimal.mod(new BigInteger("7")).equals(BigInteger.ZERO);
  }
}
