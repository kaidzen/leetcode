package org.kaidzen.study.leetcode.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ResourceFile {

    public static List<String> listFromFile(String fileName) {

        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader bufferedIsr = new BufferedReader(isr);
        ) {
            List<String> result = new ArrayList<>();
            for (; ; ) {
                String line = bufferedIsr.readLine();
                if (line == null)
                    break;
                result.add(line);
            }
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
