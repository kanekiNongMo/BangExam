package com.bangexam.bangexam.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author kaneki
 * @date 2019/7/13 17:03
 */
public class Md5Util {

    private static String md5(String str){
        return DigestUtils.md5Hex(str);
    }

    private static String inputToBack(String str){
        String salt = "kaneki";
        return md5(str + salt);
    }

    private static String backToDb(String str, String dbSalt){
        return md5(str + dbSalt);
    }

    public static String inputToDb(String str, String dbSalt){
        return backToDb(inputToBack(str), dbSalt);
    }
}
