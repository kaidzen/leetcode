package org.kaidzen.study.leetcode.y2025.hashtables;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Base 62 encoding, efficiently shorten url. Result is stored to HashMap
 */
public class EncodeDecodeTinyUrl_535 {
    private final String prefix = "http://tinyurl.com/";
    private final Map<String, String> encoded = new HashMap<>();
    private final Map<String, String> decoded = new HashMap<>();

    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";
        final String s = Base64.getEncoder().encodeToString(url.getBytes(StandardCharsets.UTF_8));
        System.out.println(s);

        EncodeDecodeTinyUrl_535 coder = new EncodeDecodeTinyUrl_535();
        final String encoded = coder.encode(url);
        System.out.println(encoded);
        System.out.println(coder.decode(encoded));
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String chars = "0123456789abcdefgklmnopqrstuwyzABCDEFGKLMNOPQRSTUWYZ";
        int base = chars.length();
        int id = encoded.size() + 1000;
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            int idx = id % base;
            sb.append(chars.charAt(idx));
            id = id / base;
        }
        final String shorted = sb.reverse().toString();
        encoded.put(longUrl, shorted);
        decoded.put(shorted, longUrl);

        return prefix + shorted;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        final String shorted = shortUrl.replace(prefix, "");
        return decoded.getOrDefault(shorted, "");
    }
}
