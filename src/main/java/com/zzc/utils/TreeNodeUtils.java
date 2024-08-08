package com.zzc.utils;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author zc.zhou
 * @Description 2.生成逻辑问题 按层遍历，生成树
 * 使用ArrayDeque 代替Stack, 但是不能存null
 * Stack LinkedList 可以存空值
 * @create 2024-08-07 16:09
 */
public class TreeNodeUtils {
  @Test
  void testArrayDequePushNull() {
    Deque<Integer> arr = new ArrayDeque<>();
    arr.push(null);
  }

  public static void main(String[] args) {
    TreeNode treeNode = generate("array", TreeNode.class, String.class);
    System.out.println(treeNode);
  }

  private TreeNodeUtils() {
  }

  //[1, null, 2, 3]
  public static <T, E> T generate(String key, Class<T> treeClass, Class<E> elementClass) {
    try {
      Deque<E> array = ArrayUtils.generate(key, Deque.class, elementClass);
      return buildTree(array, treeClass, elementClass);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static <T, E> T generateSingleNode(E value,
                                             Class<T> treeClass, Class<E> elementClass) throws Exception {
    if (value == null) {
      return null;
    }
    // 获取名为 "val" 的字段
    Field val = treeClass.getDeclaredField("val");
    // 使字段可访问，即使它是私有的
    val.setAccessible(true);
    Constructor<T> constructor = treeClass.getDeclaredConstructor();
    constructor.setAccessible(true); // Make the constructor accessible
    T node = constructor.newInstance();
    if (elementClass == Integer.class || elementClass == int.class) {
      val.setInt(node, (Integer) value);
    } else if (elementClass == String.class) {
      val.set(node, String.valueOf(value));
    }
    return node;
  }

  private static <T, E> T buildTree(Deque<E> array,
                                    Class<T> treeClass, Class<E> elementClass) throws Exception {
    //check first element -> root
    if (array.isEmpty() || array.peek() == null) {
      return null;
    }
    // 获取名为 "val" 的字段
    Field val = treeClass.getDeclaredField("val");
    Field left = treeClass.getDeclaredField("left");
    Field right = treeClass.getDeclaredField("right");
    // 使字段可访问，即使它是私有的
    val.setAccessible(true);
    left.setAccessible(true);
    right.setAccessible(true);

    E rootVal = array.pop();

    T root = generateSingleNode(rootVal, treeClass, elementClass);

    //已经创建好node的集合 某一层的树的节点
    Stack<T> nodeStack = new Stack<>();
    nodeStack.push(root);

    while (!array.isEmpty()) {
      //栈顶元素弹出
      if (nodeStack.isEmpty()) {
        break;
      }
      T currentNode = nodeStack.pop();
      if (currentNode != null) {
        //构建左右节点
        if (!array.isEmpty()) {
          E leftValue = array.pop();
          T leftNode = generateSingleNode(leftValue, treeClass, elementClass);
          left.set(currentNode, leftNode);
          //左节点加入 nodeStack
          nodeStack.push(leftNode);
        }
        if (!array.isEmpty()) {
          E rightValue = array.pop();
          T rightNode = generateSingleNode(rightValue, treeClass, elementClass);
          right.set(currentNode, rightNode);
          //右节点加入 nodeStack
          nodeStack.push(rightNode);
        }
      }
    }
    return root;
  }
}

class TreeNode {
  String val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(String val) {
    this.val = val;
  }

  TreeNode(String val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}