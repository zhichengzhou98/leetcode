package com.zzc.leetcode_jan;

import java.util.Stack;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-01-11 22:31
 */
public class AddMinimum {
    public int addMinimum(String word) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (current == 'a') {
                if (stack.isEmpty()) {
                    stack.push(current);
                }else {
                    char pre = stack.peek();
                    if (pre == 'a') {
                        res+=2;
                    }else if (pre == 'b') {
                        stack.pop();
                        res+=1;
                    }
                }
            }else if (current == 'b') {
                if (stack.isEmpty()) {
                    //stack.push(current);
                    res+=1;
                    stack.push('a');
                    stack.push(current);
                }else {
                    char pre = stack.peek();
                    if (pre == 'a') {
                        stack.push(current);
                    }else if (pre == 'b') {
                        res+=2;
                    }
                }
            }else {
                if (stack.isEmpty()) {
                    //stack.push(current);
                    res+=2;
                }else {
                    char pre = stack.peek();
                    if (pre == 'a') {
                        res+=1;
                        stack.pop();
                    }else if (pre == 'b') {
                        stack.pop();
                        stack.pop();
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            res += 3 - stack.size();
        }
        return res;
    }
}
