package com.zzc.leetcode_jan;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-01-10 12:04
 */
public class MinLength {
    public static void main(String[] args) {
        System.out.println('1' == '1');
    }
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'B' && !stack.isEmpty() &&stack.peek() == 'A'){
                stack.pop();
            }else if (c == 'D' && !stack.isEmpty() && stack.peek() == 'C'){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.size();
    }

    public int minLength1(String s) {
        while (true) {
            int len = s.length();
            s = s.replaceAll("AB", "").replaceAll("CD", "");
            if (s.length() == len || s.length() == 0) {
                break;
            }
        }
        return s.length();
    }
}
