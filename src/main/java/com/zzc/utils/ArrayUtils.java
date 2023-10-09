package com.zzc.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-27 17:58
 */
public class ArrayUtils {
    public static <T> T generate(String key, Class<?>... types) throws IOException {
        Properties properties = loadProperties();
        String arrayStr = properties.getProperty(key).replace("\"", "");

        if (types.length == 1) {
            Class<?> type1 = types[0];
            if (type1 == int[][].class) {
                return (T) parse2DIntArray(arrayStr);
            } else if (type1 == int[].class) {
                return (T) parse1DIntArray(arrayStr);
            }else if (type1 == char[][].class) {
                return (T)parse2DCharArray(arrayStr);
            }
        } else if (types.length == 2) {
            Class<?> type1 = types[0];
            Class<?> type2 = types[1];
            if (type1 == List.class) {
                return (T) parseToList(arrayStr, type2);
            }
        } else if (types.length == 3) {
            Class<?> type1 = types[0];
            Class<?> type2 = types[1];
            Class<?> type3 = types[2];
            if (type1 == List.class && type2 == List.class) {
                return (T) parse2DList(arrayStr, type3);
            }
        }

        return null;
    }

    private static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream stream = ArrayUtils.class.getClassLoader().getResourceAsStream("testCase.properties")) {
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
                .map(subArray -> Arrays.stream(subArray).map(s->s.charAt(0)).toArray(Character[]::new))
                .toArray(Character[][]::new);
    }

    private static int[] parse1DIntArray(String arrayStr) {
        // 解析一维数组
        //转一维数组
        String[] split = arrayStr.substring(1, arrayStr.length() - 1).split(",");
        return Arrays.stream(split).map(Integer::parseInt).mapToInt(Integer::intValue).toArray();
    }

    private static <E> List<E> parseToList(String arrayStr, Class<?> type) {
        // 解析列表
        //转链表
        String[] split = arrayStr.substring(1, arrayStr.length() - 1).split(",");
        return (List<E>)Arrays.stream(split).map(e -> parseElement(e, type)).collect(Collectors.toList());
    }

    private static <E> List<List<E>> parse2DList(String arrayStr, Class<E> elementType) {
        String substring = arrayStr.substring(1, arrayStr.length() - 1);
        String[] arrays = substring.replace("],[", "];[").split(";");
        List<List<E>> result = Arrays.stream(arrays)
                .map(arr -> {
                    String substring1 = arr.substring(1, arr.length() - 1);
                    String[] split = substring1.split(",");

                    List<E> innerList = Arrays.stream(split)
                            .map(element -> parseElement(element, elementType))
                            .collect(Collectors.toList());

                    return innerList;
                })
                .collect(Collectors.toList());
        return result;
    }

    private static <E> E parseElement(String element, Class<E> elementType) {
        if (elementType == Integer.class) {
            return (E) Integer.valueOf(element);
        } else if (elementType == String.class) {
            return (E) element;
        } else {
            throw new IllegalArgumentException("Unsupported type for List.");
        }
    }
   /* public static <T> T generate(String key1, Class... types) {
        Properties properties = new Properties();
        InputStream stream = ArrayUtils.class.getClassLoader().getResourceAsStream("testCase.properties");
        try {
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String arrayStr = (String) properties.get(key1);
        if (types.length == 1) {
            Class<T> type1 = types[0];
            // 获取泛型类型的 Class 对象
            if (int[][].class.equals(type1)) {
                //转成二维数组 去掉首尾 [ ]
                //substring 按逗号分隔
                return (T) parse2DIntArray(arrayStr);
            }else if (int[].class.equals(type1)) {

            }
        }else if (types.length == 2) {
            Class<T> type1 = types[0];
            Class<T> type2 = types[1];
            if (List.class.isAssignableFrom(type1)) {
                //转链表
                String[] split = arrayStr.substring(1, arrayStr.length() - 1).split(",");
                if (type2 == Integer.class) {
                    return (T)Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
                }else if (type2 == String.class) {
                    return (T)Arrays.stream(split).collect(Collectors.toList());
                }
            }
        }else if (types.length == 3) {
            //List<List<>>
            Class<T> type1 = types[0];
            Class<T> type2 = types[1];
            Class<T> type3 = types[2];
            if (List.class.isAssignableFrom(type1)) {
                if (List.class.isAssignableFrom(type2)) {
                    //转成二维链表 去掉首尾 [ ]
                    String substring = arrayStr.substring(1, arrayStr.length() - 1);
                    //substring 按逗号分隔
                    String[] arrays = substring.replace("],[", "];[").split(";");
                    if (type3 == Integer.class) {
                        List<List<Integer>> collect = Arrays.stream(arrays).map(arr -> {
                            //去掉首尾 [ ]
                            String substring1 = arr.substring(1, arr.length() - 1);
                            String[] split = substring1.split(",");
                            return Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
                        }).collect(Collectors.toList());
                        return (T) collect;
                    }else if (type3 == String.class) {
                        List<List<String>> collect = Arrays.stream(arrays).map(arr -> {
                            //去掉首尾 [ ]
                            String substring1 = arr.substring(1, arr.length() - 1);
                            String[] split = substring1.split(",");
                            return Arrays.stream(split).collect(Collectors.toList());
                        }).collect(Collectors.toList());
                        return (T) collect;
                    }
                }
            }
        }
        return null;
    }*/

}
