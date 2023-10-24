package com.zzc.leetcode_oct;

import java.util.*;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-10-23 16:00
 */
public class MinGroupsForValidAssignment {
    public static void main(String[] args) {
        MinGroupsForValidAssignment mGFVA = new MinGroupsForValidAssignment();
        //System.out.println(mGFVA.minGroupsForValidAssignment(new int[]{2, 2, 2, 1, 1, 4,4,4,4}));
        System.out.println(mGFVA.minGroupsForValidAssignment(new int[]{2, 2, 2, 2, 2, 4,4,4,4,4,6,6,6,6,6,6,6}));
    }

    public int minGroupsForValidAssignment(int[] nums) {
        //key 为 值， value为出现的次数
        Map<Integer, Integer> valueCnts = new HashMap<>();
        for (int i : nums) {
            valueCnts.put(i, valueCnts.getOrDefault(i, 0) + 1);
        }
        int[] cnts = valueCnts.values().stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(cnts);
        int r = cnts[cnts.length - 1];
        while (r >= 1) {
            if (checkMedRight(cnts, r)) {
                break;
            }else {
                r--;
            }
        }

        //求组数 每组med个元素
        int res = 0;
        for(int i : cnts) {
            //向上取整
            res += (i - 1) / r + 1;
        }
        return res;
    }

    /*public int minGroupsForValidAssignment(int[] nums) {
        //key 为 值， value为出现的次数
        Map<Integer, Integer> valueCnts = new HashMap<>();
        for (int i : nums) {
            valueCnts.put(i, valueCnts.getOrDefault(i, 0) + 1);
        }
        int[] cnts = valueCnts.values().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(cnts);
        int r = cnts[cnts.length - 1];
        while (r >= 1) {
            if (checkMedRight(cnts, r)) {
                break;
            } else {
                r--;
            }
        }
        int res = 0;
        for(int i : cnts) {
            //向上取整
            res += (i - 1) / r + 1;
        }
        return res;
    }*/

    public boolean checkMedRight(int[] cnts, int med) {
        // a * (med) + b * (med - 1) == cnts[i], a>=0, b>=0
        for (int i = 0; i < cnts.length; i++) {
            int current = cnts[i];
            int shang = current / med;
            int yushu = current % med;
            if (yushu != 0 && shang + yushu < med - 1) {
                return false;
            }
        }
        return true;
    }
}
