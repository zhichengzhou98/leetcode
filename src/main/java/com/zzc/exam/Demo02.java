package com.zzc.exam;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zzc
 * @Description
 * @create 2022-12-13 22:20
 */
public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        //用于存放所有字符串集合
        Set<String> collect = Arrays.stream(s).collect(Collectors.toSet());
        //用于存放满足条件的字符串
        ArrayList<String> result = new ArrayList<>();
        //依次遍历每个字符串
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            String substring = s1.substring(0, s1.length() - 1);
            if(isManzu(substring,collect)){
                result.add(s1);
            }
        }
        if(result.size() == 0){
            System.out.println("");
        }
        String[] strings = new String[result.size()];
        for (int i = 0;i <result.size();i++){
            strings[i] = result.get(i);
        }
        Arrays.sort(strings);
        System.out.println(strings[strings.length-1]);
    }

    public static boolean isManzu(String s,Set set){
        if(s.length()==0){
            return true;
        }
        if(set.contains(s)){
            return isManzu(s.substring(0,s.length()-1),set);
        }else {
            return false;
        }


    }
}
