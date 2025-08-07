package com.project.Utils;

import jakarta.servlet.http.HttpServletRequest;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import java.util.Base64;

public class GeneralUtils {
    public final static CustomLogger LOGGER = new CustomLogger(GeneralUtils.class);
    private static final String SECRET_KEY = "1234567890123456"; // 16-byte key for AES-128

    public static boolean hasText(String str) {
        return str != null && str.length() > 0;
    }


    public static String getIpFromRequest(HttpServletRequest request) {
        String ip = request.getHeader("Cf-Connecting-Ip");
        if (!hasText(ip)) {
            ip = request.getHeader("x-forwarded-for");
            if (!hasText(ip)) {
                ip = request.getRemoteAddr();
            }
        }
        return ip;
    }

    public static void printRequestData(HttpServletRequest request) {
        LOGGER.log(String.format(
                "request data: url - %s, query string - %s, ip - %s, referrer - %s, user-agent: %s",
                request.getRequestURI(),
                request.getQueryString(),
                getIpFromRequest(request),
                request.getHeader("referer"),
                request.getHeader("User-Agent")
        ));
    }


    public static void sleep (long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    public static String encrypt(String input) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String encryptedInput) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decoded = Base64.getDecoder().decode(encryptedInput);
            byte[] original = cipher.doFinal(decoded);
            return new String(original, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Decryption failed", e);
        }
    }




}
