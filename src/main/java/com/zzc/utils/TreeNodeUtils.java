package com.zzc.utils;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zc.zhou
 * @Description 2.生成逻辑问题 按层遍历，生成树
 * @create 2024-08-07 16:09
 */
public class TreeNodeUtils {
  public static void main(String[] args) throws IOException {
    List<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(null);
    arr.add(2);
    arr.add(3);
    System.out.println(arr.size());
    Stack<Integer> stack = new Stack<>();
    for (int i = arr.size() - 1; i >= 0; i--) {
      stack.push(arr.get(i));
    }
    TreeNode treeNode = generate(stack, TreeNode.class, Integer.class);
    System.out.println(treeNode);
  }

  private TreeNodeUtils() {
  }

  //[1, null, 2, 3]
  public static <T> T generate(Stack<Integer> array, Class<T> treeClass, Class<?> elementClass) throws IOException {
    try {
      //
      Constructor<T> constructor = treeClass.getDeclaredConstructor();
      constructor.setAccessible(true); // Make the constructor accessible
      return buildTree(array, 0, constructor, treeClass, elementClass);
    } catch (NoSuchMethodException e) {
      throw new IOException("TreeNode class must have a constructor with a single value parameter"
          + ".", e);
    } catch (NoSuchFieldException e) {
      throw new RuntimeException(e);
    }
  }

  private static <T> T generateSingleNode(Integer value, Constructor<T> constructor,
                                          Class<T> treeClass, Class<?> elementClass) throws NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException {
    if (value == null) {
      return null;
    }
    // 获取名为 "val" 的字段
    Field val = treeClass.getDeclaredField("val");
    // 使字段可访问，即使它是私有的
    val.setAccessible(true);
    T node = constructor.newInstance();
    if (elementClass == Integer.class || elementClass == int.class) {
      val.setInt(node, value);
    } else if (elementClass == String.class) {
      val.set(node, String.valueOf(value));
    }
    return node;
  }

  private static <T> T buildTree(Stack<Integer> array, int index, Constructor<T> constructor,
                                 Class<T> treeClass, Class<?> elementClass) throws IOException,
      NoSuchFieldException {
    if (index >= array.size() || array.get(index) == null) {
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


    //已经创建好node的集合 某一层的树的节点
    Stack<Integer> nodeStack = new Stack<>();
    nodeStack.push(array.pop());
    try {

      T root = null;
      while (!nodeStack.isEmpty()) {
        //栈顶元素弹出
        Integer pop = nodeStack.pop();
        if (pop != null) {
          T currentNode = generateSingleNode(pop, constructor, treeClass, elementClass);
          if (root == null) {
            root = currentNode;
          }
          //构建左右节点
          if (!array.isEmpty()) {
            Integer leftValue = array.pop();
            //左节点加入 nodeStack
            nodeStack.push(leftValue);
            T leftNode = generateSingleNode(leftValue, constructor, treeClass, elementClass);
            left.set(currentNode, leftNode);
          } else {
            break;
          }
          if (!array.isEmpty()) {
            Integer rightValue = array.pop();
            //左节点加入 nodeStack
            nodeStack.push(rightValue);
            T rightNode = generateSingleNode(rightValue, constructor, treeClass, elementClass);
            right.set(currentNode, rightNode);
          } else {
            break;
          }
        }
      }

      return root;
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
             NoSuchFieldException e) {
      throw new IOException("Failed to create tree node.", e);
    }
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