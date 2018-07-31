package com.sxctc.util;

import java.io.IOException;

/**
 * @author liuzc
 * @version V1.0
 * @ClassName: Base64Util
 * @Description: //TODO
 * @date 2018/7/18 上午10:11
 */
public class Base64Util {
    /**
     * @Title encodeString
     * @Description 使用Base64算法对字符串进行编码
     * @Param [str]
     * @Return java.lang.String
     * @Author liuzc
     * @Date 2018/7/18 上午10:11
     **/
    public static String encodeString(String str) {
        sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
        return encoder.encodeBuffer(str.getBytes()).trim();
    }

    /**
     * @Title decodeString
     * @Description 使用Base61算法对字符串进行解码
     * @Param [str]
     * @Return java.lang.String
     * @Author liuzc
     * @Date 2018/7/18 上午10:12
     **/
    public static String decodeString(String str) {
        sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
        try {
            return new String(dec.decodeBuffer(str));
        } catch (IOException io) {
            throw new RuntimeException(io.getMessage(), io.getCause());
        }
    }
}
