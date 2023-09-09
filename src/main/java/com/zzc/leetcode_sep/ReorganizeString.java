package com.zzc.leetcode_sep;

import java.util.PriorityQueue;

/**
 * @author zc.zhou
 * @Description 767. 重构字符串
 * @create 2023-09-05 12:29
 */
public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println(reorganizeString("aaab"));
    }

    public static String reorganizeString(String s) {
        //统计每个字符出现的次数
        int[] chCnts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chCnts[s.charAt(i) - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));
        for (int i = 0; i < chCnts.length; i++) {
            if (chCnts[i] != 0) {
                //[字符序号， 出现的次数]
                pq.add(new int[]{i, chCnts[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        int[] current = pq.poll();
        while (true) {
            sb.append((char) (current[0] + 'a'));
            current[1] = current[1] - 1;
            if (current[1] != 0) {
                //只剩下当前拼接的字符，一定会相邻
                if (pq.isEmpty()) {
                    return "";
                }else {
                    //取出剩下的其他字符，从次数最多的开始取
                    //一定要先取出下一个，再把当前的放回！！！
                    int[] next = pq.poll();
                    //由于当前字符没有用完，需要放回到队列中
                    pq.add(current);
                    current = next;
                }
            }else {
                //当前字符用完，也没有剩下其他字符
                if (pq.isEmpty()) {
                    return sb.toString();
                }
                //当前字符用完，剩下其他字符
                current = pq.poll();
            }
        }
    }
}
