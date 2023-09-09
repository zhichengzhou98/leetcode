package com.zzc.leetcode_sep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-08 12:16
 */
public class NumMatchingSubseq {
    public static void main(String[] args) {
        NumMatchingSubseq numMatchingSubseq = new NumMatchingSubseq();
        String s = "abcde";
        String[] words = {"a","bb","acd","ace"};
        System.out.println(numMatchingSubseq.numMatchingSubseq(s, words));
     }

    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                List<Integer> list = map.get(c);
                list.add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (isSubseq(map, words[i])) {
                res++;
            }
        }

        return res;
    }

    //判断一个子字符串是否满足条件
    public boolean isSubseq(Map<Character, List<Integer>> map, String sub) {
        int index = -1;
        for (int i = 0; i < sub.length(); i++) {
            //第i个字符
            char c = sub.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            boolean flag = false;
            //字符c所出现的下标， 找到最靠左的一个
            //二分查找
            List<Integer> cList = map.get(c);
            if (cList.get(cList.size() -1) <= index) {
                return false;
            }
            index = leftBoundary(cList, index);
        }
        return true;
    }

    public int leftBoundary(List<Integer> nums, int target){
        int l = 0;
        int r = nums.size() - 1;
        int med = (r - l) / 2 + l;
        while (l < r) {
            if (checkMed(nums.get(med), target)) {
                r = med;
            }else {
                l = med + 1;
            }
            med = (r - l) / 2 + l;
        }
        return nums.get(med);
    }

    public boolean checkMed(int med,int target) {
        if (med > target) {
            return true;
        }
        return false;
    }
}
