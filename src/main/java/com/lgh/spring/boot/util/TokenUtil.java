package com.lgh.spring.boot.util;

import com.alibaba.fastjson.JSON;
import com.lgh.spring.boot.pojo.developer.TokenUser;
import org.springframework.util.StringUtils;

public class TokenUtil {

    public static boolean validateUserToken(String token) {
        TokenUser tokenUser = decodeToken(token);
        return tokenUser != null;
    }

    public static TokenUser getUser(String token) {
        return decodeToken(token);
    }

    public static String encodeToken(TokenUser tokenUser) {
        if (tokenUser == null){
            return null;
        }
        String userStr = JSON.toJSONString(tokenUser);
        return CipherUtil.base64Encode(userStr);
    }

    public static TokenUser decodeToken(String token) {
        if (StringUtils.isEmpty(token)){
            return null;
        }
        System.out.println(token);
        try {
            String decode = CipherUtil.base64Decode(token);
            return JSON.toJavaObject(JSON.parseObject(decode), TokenUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
