package es.sanchez.david.chat.core.util;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtil {
    public static String hashPassword(String password) {
        return DigestUtils.sha256Hex(password);
    }
}
