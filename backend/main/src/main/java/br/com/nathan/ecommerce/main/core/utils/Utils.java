package br.com.nathan.ecommerce.main.core.utils;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class Utils {

    public static Boolean TrueIfNull(Boolean value) {
        return value == null || value;
    }

    public static String Hash256(String value) {
        return Hashing.sha256()
                .hashString(value, StandardCharsets.UTF_8)
                .toString();
    }
}
