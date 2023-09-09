package com.zzc.leetcode;

import java.util.Stack;


/**
 * @author zc.zhou
 * @Description 1021. 删除最外层的括号 (()())(()) -> ()()()
 * @create 2023-07-18 10:01
 */
public class RemoveOuterParentheses {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }

    public static String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            }
            sb.append(c);
            if (stack.isEmpty()) {
                int length = sb.length();
                if (length > 2) {
                    res.append(sb.substring(1, length - 1));
                }
                sb = new StringBuilder();
            }
        }
        return res.toString();
    }
}
