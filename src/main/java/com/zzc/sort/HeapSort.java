package com.zzc.sort;

import com.zzc.leetcode_aug.FindKthLargest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-19 21:59
 */
public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        //int[] arr = new int[]{21, 18, 14, 15, 2};
        Properties properties = new Properties();
        InputStream stream = FindKthLargest.class.getClassLoader().getResourceAsStream("testCase.properties");
        try {
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String arrayStr = (String) properties.get("array");
        String[] split = arrayStr.split(",");
        int[] array = Arrays.stream(split).map(Integer::parseInt).mapToInt(Integer::intValue).toArray();
        long start = System.currentTimeMillis();
        heapSort.heapSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end -start);
        //System.out.println(Arrays.toString(array));
    }


    public void heapSort(int[] arr) {
        //升序 大顶堆 a[i] >= a[2i+1] && a[i] >= a[2i+2]
        //从最后一个叶子节点开始排序 len / 2 -1
        //只有第一次需要将所有的非叶子结点构建成大顶堆
        //再将最大值（根节点）与最后一个叶子结点交换后，只需要从根节点开始重新构造大顶堆
        int len = arr.length;
        //最后一个叶子结点
        int lastLeaveIndex = len / 2 - 1;
        while (lastLeaveIndex >= 0) {
            checkSonNode(lastLeaveIndex, arr, len);
            lastLeaveIndex--;
        }
        while (len >= 2) {

            //构造完大顶堆后交换第一个元素（最大值）与最后一个元素
            int temp = arr[0];
            arr[0] = arr[len - 1];
            arr[len - 1] = temp;
            len--;
            //从根节点开始重新构造大顶堆
            checkSonNode(0, arr, len);
        }

    }
    /*public void heapSort(int[] arr) {
        //升序 大顶堆 a[i] >= a[2i+1] && a[i] >= a[2i+2]
        //从最后一个叶子节点开始排序 len / 2 -1
        int len = arr.length;
        while (len >= 2) {
            //最后一个叶子结点
            int lastLeaveIndex = len / 2 - 1;
            while (lastLeaveIndex >= 0) {
                checkSonNode(lastLeaveIndex, arr, len);
                lastLeaveIndex--;
            }
            //构造完大顶堆后交换第一个元素（最大值）与最后一个元素
            int temp = arr[0];
            arr[0] = arr[len - 1];
            arr[len - 1] = temp;
            len--;
        }

    }*/


    private void checkSonNode(int lastLeaveIndex, int[] arr, int len) {
        if (lastLeaveIndex > len / 2 - 1) {
            //叶子结点 不用检查
            return;
        }

        int lastLeave = arr[lastLeaveIndex];
        int lastLeaveLeftIndex = lastLeaveIndex * 2 + 1;
        int lastLeaveRightIndex = lastLeaveLeftIndex + 1;
        int lastLeaveLeft = arr[lastLeaveLeftIndex];

        int largest = lastLeaveIndex;
        //左子节点比根节点大
        if (lastLeaveLeft > lastLeave) {
            largest = lastLeaveLeftIndex;
        }

        //右子节点比左子节点和根节点大
        if(lastLeaveRightIndex < len && arr[lastLeaveRightIndex] > arr[largest]) {
            largest = lastLeaveRightIndex;
        }

        //如果最大元素不是根节点
        if(largest != lastLeaveIndex) {
            arr[lastLeaveIndex] = arr[largest];
            arr[largest] = lastLeave;
            //检查交换后的左、右子节点
            checkSonNode(largest, arr, len);
        }

    }

    /*private void checkSonNode(int lastLeaveIndex, int[] arr, int len) {
        if (lastLeaveIndex > len / 2 - 1) {
            //叶子结点 不用检查
            return;
        }

        int lastLeave = arr[lastLeaveIndex];
        //不确定最后一个叶子结点有没有右子节点
        int lastLeaveLeftIndex = lastLeaveIndex * 2 + 1;
        int lastLeaveRightIndex = lastLeaveLeftIndex + 1;
        int lastLeaveLeft = arr[lastLeaveLeftIndex];
        if (lastLeaveRightIndex < len) {
            //有右子节点
            int lastLeaveRight = arr[lastLeaveRightIndex];
            if (lastLeave < lastLeaveLeft || lastLeave < lastLeaveRight) {
                //需要交换
               *//* if (lastLeaveLeft >= lastLeaveRight) {
                    //跟左子节点交换
                    arr[lastLeaveIndex] = lastLeaveLeft;
                    arr[lastLeaveLeftIndex] = lastLeave;
                    //检查左子结点是否满足最大堆
                    checkSonNode(lastLeaveLeftIndex, arr, len);
                } else {
                    //跟右子节点交换
                    arr[lastLeaveIndex] = lastLeaveRight;
                    arr[lastLeaveRightIndex] = lastLeave;
                    //检查右子结点是否满足最大堆
                    checkSonNode(lastLeaveRightIndex, arr, len);
                }*//*
                arr[lastLeaveIndex] = Math.max(lastLeaveLeft, lastLeaveRight);
                int index = lastLeaveLeft >= lastLeaveRight?lastLeaveLeftIndex: lastLeaveRightIndex;
                arr[index] = lastLeave;
                checkSonNode(index, arr, len);
            }
        } else {
            //无右子节点
            if (lastLeaveLeft > lastLeave) {
                //交换左子结点
                arr[lastLeaveIndex] = lastLeaveLeft;
                arr[lastLeaveLeftIndex] = lastLeave;
                //检查左子结点是否满足最大堆
                checkSonNode(lastLeaveLeftIndex, arr, len);
            }
        }
    }*/
}
