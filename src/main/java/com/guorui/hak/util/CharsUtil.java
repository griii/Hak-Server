package com.guorui.hak.util;

public class CharsUtil {

    public static String firstToSmallCase(String s){
        //首字母变小写
        char[] chars = s.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
