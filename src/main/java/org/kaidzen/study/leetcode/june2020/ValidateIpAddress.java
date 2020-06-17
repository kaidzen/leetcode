package org.kaidzen.study.leetcode.june2020;

import java.util.Arrays;
import java.util.function.Predicate;

public class ValidateIpAddress {

    enum Result {
        IPv4("IPv4", "\\."),
        IPv6("IPv6", ":"),
        Neither("Neither", "");

        private final String result;
        private final String delimiter;

        Result(String result, String delimiter) {
            this.result = result;
            this.delimiter = delimiter;
        }

        public String getResult() {
            return result;
        }

        public String getDelimiter() {
            return delimiter;
        }
    }

    public String validIPAddress(String IP) {
        if (null == IP) {
            return Result.Neither.getResult();
        }
        boolean ip4Candidate = IP.contains(".");
        boolean ip6Candidate = IP.contains(":");

        if (ip4Candidate) {
            return validateIp4(IP);
        } else if (ip6Candidate) {
            return validateIp6(IP);
        }
        return Result.Neither.getResult();
    }

    private String validateIp6(String ip) {
        String[] octets = ip.split(Result.IPv6.getDelimiter());
        Predicate<String> singleZero = str -> {
            if (str.startsWith("0") && str.length() <=4){
                return true;
            } else return str.length() <= 4;
        };
        Predicate<String> properLength = str -> str.length() >= 1 && str.length() <= 4;
        Predicate<String> inRange = str -> parseIpv6(str) <= 65535 && parseIpv6(str) >= 0;
        if (octets.length != 8 || ip.endsWith(Result.IPv6.getDelimiter())) {
            return Result.Neither.getResult();
        }
        long validation = Arrays.stream(octets)
                .filter(singleZero)
                .filter(properLength)
                .filter(inRange)
                .count();
        return validation == 8 ? Result.IPv6.getResult() : Result.Neither.getResult();
    }

    private int parseIpv6(String str) {
        int integer;
        try {
            integer = Integer.parseInt(str, 8);
        } catch (NumberFormatException e) {
            return -1;
        }
        return integer;
    }

    private String validateIp4(String ip) {
        String[] octets = ip.split(Result.IPv4.getDelimiter());
        Predicate<String> singleZero = str -> {
            if (str.startsWith("0") && str.length() == 1) {
                return true;
            } else return !str.startsWith("0") && str.length() <= 3;
        };
        Predicate<String> inRange = str -> parseIpv4(str) <= 255 && parseIpv4(str) >= 0;
        Predicate<String> eachIsDigit = str -> {
            boolean isDigit = true;
            for (char ch : str.toCharArray()) {
                isDigit = isDigit && Character.isDigit(ch);
            }
            return isDigit;
        };
        if (octets.length != 4 || ip.endsWith(".")) {
            return Result.Neither.getResult();
        }
        long validated = Arrays.stream(octets)
                .filter(eachIsDigit)
                .filter(inRange)
                .filter(singleZero)
                .count();
        return validated == 4 ? Result.IPv4.getResult() : Result.Neither.getResult();
    }

    private int parseIpv4(String str) {
        int integer;
        try {
            integer = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
        return integer;
    }

    public static void main(String[] args) {
        ValidateIpAddress ipValidator = new ValidateIpAddress();
//        Input: "2001:0db8:85a3:00000:0:8A2E:0370:7334"
//        Output: "Neither"
        System.out.println(ipValidator.validIPAddress("2001:0db8:85a3:00000:0:8A2E:0370:7334"));
//        Input: "1e1.4.5.6"
//        Output: "Neither"
        System.out.println(ipValidator.validIPAddress("1w1.4.5.6"));
//        Input: "01.01.01.01"
//        Output: "Neither"
        System.out.println(ipValidator.validIPAddress("01.01.01.01"));
//        Input: "1.1.1.1."
//        Output: "Neither"
        System.out.println(ipValidator.validIPAddress("1.1.1.1."));
//        Input: "2001:0db8:85a3:0:0:8A2E:0370:7334:"
//        Output: "Neither"
        System.out.println(ipValidator.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
//        Input: "172.16.254.1"
//        Output: "IPv4"
        System.out.println(ipValidator.validIPAddress("172.16.254.1"));
//        Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
//        Output: "IPv6"
        System.out.println(ipValidator.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
//        Input: "256.256.256.256"
//        Output: "Neither"
        System.out.println(ipValidator.validIPAddress("256.256.256.256"));
    }
}
