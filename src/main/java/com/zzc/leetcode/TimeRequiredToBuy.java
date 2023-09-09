package com.zzc.leetcode;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-29 19:05
 */
public class TimeRequiredToBuy {
    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy1(new int[]{84,49,5,24,70,77,87,8}, 3));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int sec = 0;
        while (tickets[k] > 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] != 0) {
                    tickets[i]--;
                    sec++;
                }

                if(k == i && tickets[i] == 0){
                    return sec;
                }
            }
        }
        return sec;
    }

    public static int timeRequiredToBuy1(int[] tickets, int k) {
        int sec = 0;

        for (int i = 0; i < tickets.length; i++) {
            if(i > k && tickets[i] >= tickets[k]) {
                sec = sec - 1;
            }
            sec = sec + Math.min(tickets[k], tickets[i]);
            /*if (i == k && tickets[k] == tickets[i]) {
                return sec;
            }*/
        }

        return sec;
    }
}
