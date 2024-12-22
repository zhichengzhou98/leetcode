package com.topic.baoli;

/**
 * @author zc.zhou
 * @Description 661 图片平滑器
 * @create 2024-11-18 10:55
 */
public class ImageSmoother {
  public int[][] imageSmoother(int[][] img) {
    int m = img.length;
    int n = img[0].length;
    int[][] res = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int cnts = 0;
        // 统计[i, j]周围节点的数目
        int sum = 0;
        for (int k = Math.max(0, i - 1); k <= Math.min(i + 1, m - 1); k++) {
          for (int l = Math.max(0, j - 1); l <= Math.min(j + 1, n - 1); l++) {
            cnts++;
            sum += img[k][l];
          }
        }
        res[i][j] = (int) Math.floor(sum * 1.0 / cnts);
      }
    }
    return res;
  }
}
