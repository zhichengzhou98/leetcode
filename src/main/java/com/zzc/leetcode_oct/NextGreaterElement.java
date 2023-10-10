package com.zzc.leetcode_oct;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-10 20:33
 */
public class NextGreaterElement {
    public static void main(String[] args) {

    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //key: 当前元素值 value: 下一个最大的元素 没有就为 -1
        Map<Integer, Integer> map = new HashMap<>();
        //单调递减栈 倒序遍历nums2
        Stack<Integer> stack = new Stack<>();
        int i = nums2.length - 1;
        while (i >= 0) {
            int current = nums2[i];
            while (!stack.isEmpty()) {
                //栈顶元素
                Integer peek = stack.peek();
                if (current < peek) {
                    //直接入栈
                    stack.push(current);
                    map.put(current, peek);
                    break;
                }else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                //栈为空
                stack.push(current);
                map.put(current, -1);
            }
            i--;
        }
        for (int j = 0; j < nums1.length; j++) {
            nums1[j] = map.get(nums1[j]);
        }
        return nums1;
    }
}
