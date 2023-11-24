package com.zzc.leetcode_nov;

/**
 * @author zc.zhou
 * @Description
 * @create 2023-11-23 22:11
 */
public class EntityParser {
    public String entityParser(String text) {
        return text.replace("&quot;", "\"")
                .replace("&apos;", "'")
                .replace("&gt;", ">")
                .replace("&lt;", "<")
                .replace("&frasl;", "/")
                .replace("&amp;", "&");
    }
    public String entityParser1(String text) {
        StringBuilder sb = new StringBuilder();
        int l = 0;
        while (l < text.length()){
            while (l < text.length() && text.charAt(l) !=  '&') {
                sb.append(text.charAt(l));
                l++;
            }
            if (l == text.length()) {
                return sb.toString();
            }
            int r = l + 3;
            if (r >= text.length()) {
                sb.append(text.substring(l));
                return sb.toString();
            }else if (r >= text.length() + 1){
                String sub = text.substring(l, r + 1);
                if ("&gt;".equals(sub)) {
                    sb.append(">");
                    l = r + 1;
                }else if ("&lt;".equals(sub)) {
                    sb.append("<");
                    l = r + 1;
                }else {
                    sb.append("&");
                    l = l + 1;
                }
            }
        }
        return "1";
    }
}
