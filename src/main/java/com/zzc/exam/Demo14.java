package com.zzc.exam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzc
 * @Description
 * @create 2023-03-14 21:38
 */
public class Demo14 {
    public static void main(String[] args) {

    }

    public List<String> readBinaryWatch(int turnedOn) {
        
        
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m <= 59; m++) {
                if(Integer.bitCount(h) + Integer.bitCount(m) == turnedOn){
                    res.add(h+":"+(m <= 9 ? "0" :"")+m);
                }
            }
        }
        return res;
    }

    public List<String> hours(int turnedOn) {
        List<String> res = new ArrayList<>();
        if (turnedOn == 0) {
            res.add("0");
        } else if (turnedOn == 1) {
            res.add("1");
            res.add("2");
            res.add("4");
            res.add("8");
        } else if (turnedOn == 2) {
            res.add("3");
            res.add("5");
            res.add("9");
            res.add("6");
            res.add("10");
            res.add("12");
        } else if (turnedOn == 3) {
            res.add("7");
            res.add("11");
        }
        return res;
    }

    public List<String> mins(int turnedOn) {
        List<String> res = new ArrayList<>();
        if (turnedOn == 0) {
            res.add("00");
        } else if (turnedOn == 1) {
            res.add("01");
            res.add("02");
            res.add("04");
            res.add("08");
            res.add("16");
            res.add("32");
        } else if (turnedOn == 2) {
            res.add("03");
            res.add("05");
            res.add("09");
            res.add("17");
            res.add("33");
            res.add("06");
            res.add("10");
            res.add("18");
            res.add("34");
            res.add("12");
            res.add("20");
            res.add("36");
            res.add("24");
            res.add("40");
            res.add("48");
        } else if (turnedOn == 3) {
            res.add("07");
            res.add("11");
            res.add("19");
            res.add("35");
            res.add("21");
            res.add("37");
            res.add("25");
            res.add("41");
            res.add("49");
        }else if (turnedOn == 4) {
            res.add("15");
            res.add("23");
            res.add("39");
            res.add("35");
            res.add("21");
            res.add("37");
            res.add("25");
            res.add("41");
            res.add("49");
        }
        return res;
    }
}
