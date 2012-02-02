package com.ks.code.creator.service.support;

public class ShortUrlUtil {

    public static String base48Encode(Long no) {
            Double num = Double.valueOf(no);
            String charSet = "23456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ";
            Integer length = charSet.length();
            String encodeString = new String();
            while (num > length) {
                    encodeString = charSet.charAt(num.intValue() % length) + encodeString;
                    num = Math.ceil(new Double(num / length) - 1);
            }
            encodeString = charSet.charAt(num.intValue()) + encodeString;

            return encodeString;
    }
	
}
