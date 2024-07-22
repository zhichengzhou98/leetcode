package com.zzc.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-07-22 15:59
 */
class UnionFindTest {

  @Test
  void unionV2() {
    UnionFind uf = new UnionFind(10);
    uf.unionV2(1, 2);
    uf.unionV2(2, 3);
    uf.unionV2(4, 3);
    uf.unionV2(5, 3);
  }
}