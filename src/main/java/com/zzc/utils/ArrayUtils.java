package com.zzc.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-27 17:58
 */
public class ArrayUtils {
  private ArrayUtils() {}
  public static <T> T generate(String key, Class<?>... types) throws IOException {
    Properties properties = loadProperties();
    String arrayStr = properties.getProperty(key)
        .replace("\"", "")
        .replace(" ", "");
    Object res = null;
    if (types.length == 1) {
      Class<?> type1 = types[0];
      if (type1 == int[][].class) {
        res = parse2DIntArray(arrayStr);
      } else if (type1 == int[].class) {
        res = parse1DIntArray(arrayStr);
      } else if (type1 == char[][].class) {
        res = parse2DCharArray(arrayStr);
      }
    } else if (types.length == 2) {
      Class<?> type1 = types[0];
      Class<?> type2 = types[1];
      if (type1 == List.class) {
        res = parseToList(arrayStr, type2);
      } else if (type1 == Deque.class) {
        //倒序入栈
        res =  parseToDeque(arrayStr, type2);
      }
    } else if (types.length == 3) {
      Class<?> type1 = types[0];
      Class<?> type2 = types[1];
      Class<?> type3 = types[2];
      if (type1 == List.class && type2 == List.class) {
        res = parse2DList(arrayStr, type3);
      }
    }
    if (res != null) {
      @SuppressWarnings("unchecked") T result = (T) res;
      return result;
    } else {
      return null;
    }
  }

  private static <E> Deque<E> parseToDeque(String arrayStr, Class<?> type2) {
    List<E> list = parseToList(arrayStr, type2);
    Deque<E> deque = new LinkedList<>();
    for (int i = list.size() - 1; i >= 0; i--) {
      deque.push(list.get(i));
    }
    return deque;
  }


  private static Properties loadProperties() throws IOException {
    Properties properties = new Properties();
    try (InputStream stream = ArrayUtils.class.getClassLoader().getResourceAsStream("testCase"
        + ".properties")) {
      properties.load(stream);
    }
    return properties;
  }

  private static int[][] parse2DIntArray(String arrayStr) {
    // 解析二维数组
    String[] arrays = arrayStr.substring(1, arrayStr.length() - 1).replace("],[", "];[").split(";");
    return Arrays.stream(arrays)
        .map(arr -> arr.substring(1, arr.length() - 1).split(","))
        .map(subArray -> Arrays.stream(subArray).mapToInt(Integer::parseInt).toArray())
        .toArray(int[][]::new);
  }

  private static char[][] parse2DCharArray(String arrayStr) {
    // 解析二维数组
    Character[][] characters = parse2DCharacterArray(arrayStr);
    char[][] res = new char[characters.length][];
    for (int i = 0; i < res.length; i++) {
      res[i] = new char[characters[i].length];
      for (int j = 0; j < characters[i].length; j++) {
        res[i][j] = characters[i][j];
      }
    }
    return res;
  }

  private static Character[][] parse2DCharacterArray(String arrayStr) {
    // 解析二维数组
    String[] arrays = arrayStr.substring(1, arrayStr.length() - 1).replace("],[", "];[").split(";");
    return Arrays.stream(arrays)
        .map(arr -> arr.substring(1, arr.length() - 1).split(","))
        .map(subArray -> Arrays.stream(subArray).map(s -> s.charAt(0)).toArray(Character[]::new))
        .toArray(Character[][]::new);
  }

  private static int[] parse1DIntArray(String arrayStr) {
    // 解析一维数组
    //转一维数组
    String[] split = arrayStr.substring(1, arrayStr.length() - 1).split(",");
    return Arrays.stream(split).map(Integer::parseInt).mapToInt(Integer::intValue).toArray();
  }

  private static <E> List<E> parseToList(String arrayStr, Class<?> type) {
    String[] split = arrayStr.substring(1, arrayStr.length() - 1).split(",");
    @SuppressWarnings("unchecked") List<E> res =
        (List<E>) Arrays.stream(split).map(e -> parseElement(e, type)).toList();
    return new ArrayList<>(res);
  }

  private static <E> List<List<E>> parse2DList(String arrayStr, Class<E> elementType) {
    String substring = arrayStr.substring(1, arrayStr.length() - 1);
    String[] arrays = substring.replace("],[", "];[").split(";");
    List<List<E>> collect = Arrays.stream(arrays)
        .map(arr -> {
          String substring1 = arr.substring(1, arr.length() - 1);
          String[] split = substring1.split(",");
          List<E> tmpList = Arrays.stream(split)
              .map(element -> parseElement(element, elementType))
              .toList();
          return (List<E>) new ArrayList<>(tmpList);
        })
        .toList();
    return new ArrayList<>(collect);
  }

  /**
   * <pre>
   *   private static <E> E parseElement(String element, Class<E> elementType) {
   *     if ("null".equals(element)) {
   *       return null;
   *     }
   *
   *     Object res;
   *     if (elementType == Integer.class) {
   *       res = Integer.valueOf(element);
   *     } else if (elementType == String.class) {
   *       res = element;
   *     } else {
   *       throw new IllegalArgumentException("Unsupported type for List.");
   *     }
   *
   *     //@SuppressWarnings("unchecked")
   *     E result = (E) res;
   *     return result;
   *   }
   * </pre>
   * @param element 元素值
   * @param elementType 类型
   * @return 返回对应类型的值
   * @param <E> 泛型参数
   */
  private static <E> E parseElement(String element, Class<E> elementType) {
    if ("null".equals(element)) {
      return null;
    }

    if (elementType == Integer.class) {
      return elementType.cast(Integer.valueOf(element));
    } else if (elementType == String.class) {
      return elementType.cast(element);
    } else {
      throw new IllegalArgumentException("Unsupported type for List.");
    }
  }
}
