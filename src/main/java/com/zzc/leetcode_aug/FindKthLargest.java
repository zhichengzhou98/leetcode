package com.zzc.leetcode_aug;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-08-20 11:57
 */
public class FindKthLargest {

    
    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
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

        System.out.println(findKthLargest.findKthLargest(array, 63565));
    }

    public int findKthLargest(int[] nums, int k) {
        int res = 0;
        //构建最大堆
        int len = nums.length;
        int nodeIndex = len / 2 - 1;
        //构造大顶堆
        while (nodeIndex >= 0) {
            constructHeap(nums, len, nodeIndex);
            nodeIndex--;
        }
        while (k > 0) {
            //将最大值移到最后
            res = nums[0];
            nums[0] = nums[len - 1];
            nums[len - 1] = res;
            len--;
            k--;
            constructHeap(nums, len, 0);
        }
        return res;
    }

    public void constructHeap(int[] arr, int len, int nodeIndex) {
        int current = arr[nodeIndex];
        int largest = nodeIndex;
        int leftIndex = 2 * nodeIndex +1;
        int rightIndex = leftIndex +1;
        //判断左子结点
        if (leftIndex < len && arr[leftIndex] > current) {
            largest = leftIndex;
        }
        //判断右子节点
        if(rightIndex < len && arr[rightIndex] > arr[largest]) {
            largest = rightIndex;
        }

        //重构堆
        if (largest != nodeIndex) {
            arr[nodeIndex] = arr[largest];
            arr[largest] = current;
            //递归重构 largest节点
            constructHeap(arr, len, largest);
        }
    }

}
