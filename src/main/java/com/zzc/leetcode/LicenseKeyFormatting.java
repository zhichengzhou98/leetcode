package com.zzc.leetcode;

/*
给定一个许可密钥字符串 s，仅由字母、数字字符和破折号组成。字符串由 n 个破折号分成 n + 1 组。
你也会得到一个整数 k 。我们想要重新格式化字符串s，使每一组包含 k 个字符，除了第一组，
它可以比 k 短，但仍然必须包含至少一个字符。此外，两组之间必须插入破折号，并
且应该将所有小写字母转换为大写字母。返回 重新格式化的许可密钥 。
 */
/**
 * @author zc.zhou
 * @Description
 * @create 2023-07-09 15:57
 */
public class LicenseKeyFormatting {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
    }

    /*private static String licenseKeyFormatting(String s, int k) {
        int length = s.length() - 1;
        StringBuffer sb = new StringBuffer();
        while (length >= 0) {
            for (int j = 0; j < k && length >= 0; ){
                char c = s.charAt(length);
                if (c == '-') {
                    length--;
                }else {
                    sb.append(Character.toUpperCase(c));
                    length--;
                    j++;
                }
            }
            sb.append('-');
        }
        String res = sb.reverse().toString();
        return res.replace('-',' ').trim().replace(' ','-');
    }*/


    public static String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase().replaceAll("-", "");
        s = new StringBuilder(s).reverse().toString();
        int len = s.length();
        int count = len / k;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(s.substring(i * k, (i + 1) * k));
            sb.append("-");
        }
        sb.append(s.substring(count * k));
        return sb.reverse().toString().replaceAll("^-", "");
    }
}
