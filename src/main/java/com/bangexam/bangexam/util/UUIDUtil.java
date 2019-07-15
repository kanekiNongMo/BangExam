package com.bangexam.bangexam.util;

import java.util.UUID;

/**
 * @author kaneki
 * @date 2019/7/13 17:07
 */
public class UUIDUtil {
    public static String getUuId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
