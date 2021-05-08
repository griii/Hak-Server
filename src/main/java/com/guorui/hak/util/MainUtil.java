package com.guorui.hak.util;

import org.springframework.util.DigestUtils;

public class MainUtil {

    public static String getToken(String account){
        return getMD5(account);
    }

    private static final String slat = "&%5123***&&%%$$#@";

    public static String getMD5(String str) {
        String base = str +"/"+slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

}
