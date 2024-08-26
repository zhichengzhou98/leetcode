package com.zzc.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-08-26 9:28
 */
public class ListNodeUtils {
  private ListNodeUtils() {
  }

  /**
   * 默认元素类型都是int
   *
   * @param nodeClz
   * @param <T>
   * @return
   */
  public static <T> T generate(Class<T> nodeClz) throws Exception {
    int[] nodeArray = ArrayUtils.generate("ListNode", int[].class);
    return buildNode(nodeClz, nodeArray);
  }

  private static <T> T buildNode(Class<T> nodeClz, int[] nodeArray) throws Exception {
    if (nodeArray.length == 0) {
      return null;
    }
    Field next = nodeClz.getDeclaredField("next");
    next.setAccessible(true);
    T root = generateSingleNode(nodeArray[0], nodeClz);
    T currentRoot = root;
    for (int i = 1; i < nodeArray.length; i++) {
      T nextNode = generateSingleNode(nodeArray[i], nodeClz);
      next.set(currentRoot, nextNode);
      currentRoot = nextNode;
    }
    return root;
  }

  private static <T> T generateSingleNode(int value,
                                          Class<T> nodeClz) throws Exception {
    // 获取名为 "val" 的字段
    Field val = nodeClz.getDeclaredField("val");
    // 使字段可访问，即使它是私有的
    val.setAccessible(true);
    Constructor<T> constructor = nodeClz.getDeclaredConstructor();
    constructor.setAccessible(true); // Make the constructor accessible
    T node = constructor.newInstance();
    val.setInt(node, value);
    return node;
  }

  public static <T> String printListNode(T root) {
    if (root == null) {
      return "";
    }
    List<Integer> res = new ArrayList<>();
    try {
      Class<T> nodeClz = (Class<T>) root.getClass();
      Field valField = nodeClz.getDeclaredField("val");
      Field nextField = nodeClz.getDeclaredField("next");
      valField.setAccessible(true);
      nextField.setAccessible(true);
      T currentNode = root;
      while (currentNode != null) {
        int value = (int) valField.get(currentNode);
        res.add(value);
        currentNode = (T) nextField.get(currentNode);
      }
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return res.toString();
  }
}
