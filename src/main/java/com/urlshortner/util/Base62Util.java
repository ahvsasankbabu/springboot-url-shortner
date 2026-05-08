package com.urlshortner.util;

public class Base62Util {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String encode(long id) {
        if (id == 0) {
            return "a";
        }

        StringBuilder sb = new StringBuilder();

        while (id > 0) {
            int remainder = (int) (id % 62);
            sb.append(CHARACTERS.charAt(remainder));
            id = id / 62;
        }

        return sb.reverse().toString();
    }
}