package com.zzc.leetcode;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author zc.zhou
 * @Description 1047. 删除字符串中的所有相邻重复项  "abbaca" -> "ca"
 * @create 2023-07-18 14:38
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        /*StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }*/
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
