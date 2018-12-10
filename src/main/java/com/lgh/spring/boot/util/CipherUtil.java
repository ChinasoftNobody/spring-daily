package com.lgh.spring.boot.util;

import java.nio.charset.Charset;
import java.util.Base64;

public class CipherUtil {

    public static String base64Encode(String target){
        return Base64.getEncoder().encodeToString(target.getBytes(Charset.forName("UTF-8")));
    }

    public static String base64Decode(String target) {
        return new String(Base64.getDecoder().decode(target.getBytes(Charset.forName("UTF-8"))));
    }
}
