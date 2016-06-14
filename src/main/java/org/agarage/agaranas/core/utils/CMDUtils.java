package org.agarage.agaranas.core.utils;

import java.util.*;

/**
 * Created by Nicholas on 2016/6/14.
 */
public class CMDUtils {
    public static List<Map<String, String>> tableToMaps(String table) {
        List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
        Map<String, Integer> widths = new LinkedHashMap<String, Integer>();
        String[] lines = table.split("\n");
        String key = "";
        boolean done = false;
        int length = 0;
        for (int i = 0; i < lines[0].length(); i ++) {
            char c = lines[0].charAt(i);
            if (c != ' ') {
                if (done) {
                    widths.put(key, length);
                    key = "" + c;
                    length = 1;
                    done = false;
                } else {
                    key += c;
                    length ++;
                }
            } else {
                done = true;
                length ++;
            }
        }
        for (int i = 1; i < lines.length; i ++) {
            String line = lines[i].trim();
            if (line.length() == 0) continue;
            Map<String, String> map = new HashMap<String, String>();
            int start = 0;
            for (Map.Entry<String, Integer> entry : widths.entrySet()) {
                int end = start + entry.getValue() - 1;
                String value = "";
                for (int j = start; j <= end; j ++) {
                    char c = lines[i].charAt(j);
                    if (isChinese(c)) end --;
                    value += c;
                }
                map.put(entry.getKey(), value.trim());
                start = end + 1;
            }
            maps.add(map);
        }

        return maps;
    }

    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }
}
