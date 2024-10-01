package com.topic.segmenttree;


import java.util.Arrays;

/**
 * @author zc.zhou
 * @Description 2286. 以组为单位订音乐会的门票
 * 线段树 维护区间最小值 区间和
 * @create 2024-09-28 17:12
 */
public class BookMyShow {
  public static void main(String[] args) {
    //[[5,9],[10,1],[3,3],[9,1],[10,2],[2,0]]
    BookMyShow bms = new BookMyShow(5, 9);
    bms.scatter(3, 3);
    int[] gather = bms.gather(9, 1);
    System.out.println(Arrays.toString(gather));
    bms.scatter(5, 1);
    //bms.scatter(5, 1);
  }

  int n;
  int m;
  long[] sum;
  int[] min;

  public BookMyShow(int n, int m) {
    this.n = n;
    this.m = m;
    //区间的和（区间内一共坐了多个座位） 下标从1开始
    sum = new long[4 * n];

    //区间最小值
    min = new int[4 * n];

  }

  /**
   * 在i位置新增value, 所有包含i的区间 都需要加value
   *
   * @param index 当前区间的索引
   * @param left  区间左端点
   * @param right 区间右端点
   * @param i     需要更新的位置
   * @param value 更新的值
   */
  private void add(int index, int left, int right, int i, int value) {
    if (left == right) {
      sum[index] += value;
      min[index] += value;
      return;
    }
    int med = (left + right) / 2;
    if (i <= med) {
      //更新左边区间 左边区间的索引为 2 * index
      add(2 * index, left, med, i, value);
    } else {
      //更新右区间
      add(2 * index + 1, med + 1, right, i, value);
    }
    //sum[index] += value; 所有包含i的区间 都需要加value, index所代表的区间包含i
    sum[index] = sum[2 * index] + sum[2 * index + 1];
    //min[index] += value; × 给区间[0, 0]增加1，min[0, 0]会增加1, 但是区间min[0, 10]不一定会变
    min[index] = Math.min(min[2 * index], min[2 * index + 1]);
  }

  /**
   * 查询区间和
   *
   * @param index 区间索引
   * @param left  index 区间对应的左端点
   * @param right index 区间对应的右端点
   * @param l     需要查询的区间左端点
   * @param r     需要查询的区间右端点
   * @return 区间[l, r]和
   */
  private long querySum(int index, int left, int right, int l, int r) {
    if (l <= left && r >= right) {
      return sum[index];
    }
    int med = (left + right) / 2;
    long res = 0;
    if (l <= med) {
      //向左边递归查询
      res += querySum(2 * index, left, med, l, r);
    }
    if (r > med) {
      //向右边递归查询
      res += querySum(2 * index + 1, med + 1, right, l, r);
    }
    return res;
  }

  /**
   * 查询区间[0, r]中第一个小于等于val的坐标 不存在时返回-1
   *
   * @param index
   * @param left
   * @param right
   * @param r
   * @param val
   * @return
   */
  private int findIndex(int index, int left, int right, int r, int val) {
    if (min[index] > val) {
      //区间index 最小值>= val，不存在
      return -1;
    }
    if (left == right) {
      return left;
    }
    int med = (left + right) / 2;
    // 0 <= med 一定成立
    if (min[2 * index] <= val) {
      //区间左半部分最小值<= val, 第一个索引出现在左半部分
      return findIndex(2 * index, left, med, r, val);
    }
    if (r > med) {
      return findIndex(2 * index + 1, med + 1, right, r, val);
    }
    //要查的范围不在区间右侧范围中（小于右侧的范围）
    return -1;
  }

  public int[] gather(int k, int maxRow) {
    //需要坐下k个人 => 当前排坐的人不能超过m-k
    int index = findIndex(1, 0, n - 1, maxRow, m - k);
    if (index < 0) {
      return new int[0];
    }
    //区间[index, index]和，即第index排坐了seated个人
    long seated = querySum(1, 0, n - 1, index, index);
    add(1, 0, n - 1, index, k);
    return new int[]{index, (int) seated};
  }

  public boolean scatter(int k, int maxRow) {
    //判断0-maxRow空位是否足够
    long sumSeated = querySum(1, 0, n - 1, 0, maxRow);
    long left = (maxRow + 1) * (long) m - sumSeated;
    if (left < k) {
      return false;
    }
    //查询第一个有空位的排
    int index = findIndex(1, 0, n - 1, maxRow, m - 1);
    if (index < 0) {
      return false;
    }
    while (true) {
      //查询第index排剩余的空位
      int seated = (int) querySum(1, 0, n - 1, index, index);
      int empty = m - seated;
      if (empty >= k) {
        //全部坐到index排
        add(1, 0, n - 1, index, k);
        return true;
      }
      k -= empty;
      add(1, 0, n - 1, index, empty);
      index++;
    }
  }
}
