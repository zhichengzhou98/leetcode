package com.zzc.leetcode_jan;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.junit.jupiter.api.Test;

/**
 * @author zc.zhou
 * @Description
 * @create 2024-01-23 22:14
 */
public class AlternatingSubarray {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.ofOffset("UTC", ZoneOffset.UTC));
        // 创建日期时间格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        // 格式化 LocalDateTime
        String formattedDateTime = currentDateTime.format(formatter);

        System.out.println(formattedDateTime);
    }

    @Test
    public void test() {
        int[] arr = {2,3,4,3,4};
        System.out.println(alternatingSubarray(arr));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        //System.out.println(formatter.format(Instant.now()));
        System.out.println(Instant.parse("2024-01-24T09:59:00.528Z"));
    }

    public int alternatingSubarray(int[] nums) {
        int len = -1;
        int[] diff = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            diff[i] = nums[i + 1] - nums[i];
        }
        int i = 0;
        while (true) {
            while (i < diff.length && diff[i] != 1) {
                i++;
            }
            if (i >= diff.length) {
                break;
            }else if(diff[i] == 1) {
                int j = i + 1;
                while (j < diff.length && diff[j] == -diff[j - 1]) {
                    j++;
                }
                len = Math.max(len, j - i + 1);
                //i = (j == i) ? (i + 1) : j;
                i = j;
            }

        }
        return len;
    }
}
