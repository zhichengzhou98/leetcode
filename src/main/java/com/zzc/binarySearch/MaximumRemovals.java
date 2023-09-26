package com.zzc.binarySearch;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-09-26 12:26
 */
public class MaximumRemovals {
    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0;
        int r = removable.length;
        //查找右边界
        int med = (r - l + 1 )/ 2 + l;
        while (l < r) {
            if (checkMedRight(med, s, p, removable)) {
                l = med;
            }else {
                r = med - 1;
            }
            med = (r - l + 1 ) / 2 + l;
        }
        return med;
    }

    public boolean checkMedRight(int med, String s, String p, int[] removable) {
        //med == 0, 取removable中的前0个元素
        //需要移除的元素索引
        Set<Integer> index = new HashSet<>();
        for (int i = med; i > 0; i--) {
            index.add(removable[i - 1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!index.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return isSubSeq(sb.toString(), p);
    }

    public  boolean isSubSeq(String s, String seq) {
        if (seq.length() > s.length()) {
            return false;
        }
        int i = 0;
        while (i < seq.length()) {
            char c = seq.charAt(i);
            int i1 = s.indexOf(c);
            if (i1 == -1) {
                return false;
            }else {
                s = s.substring(i1 +1);
                i++;
            }
        }
        return true;
    }
}
