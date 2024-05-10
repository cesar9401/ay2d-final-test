package com.cesar31;

import java.util.HashMap;

public class Anagram {

    public boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null) throw new IllegalArgumentException("Arguments should not be null");
        if (s1.isEmpty() || s2.isEmpty()) return false;
        if (s1.length() != s2.length()) return false;

        var length = s1.length();
        var map = new HashMap<Character, Integer>();

        for (int i = 0; i < length; i++) {
            var c1 = s1.charAt(i);
            var c2 = s2.charAt(i);

            if (!map.containsKey(c1)) {
                map.put(c1, 1);
            } else {
                map.put(c1, map.get(c1) + 1);
            }

            if (!map.containsKey(c2)) {
                map.put(c2, -1);
            } else {
                map.put(c2, map.get(c2) - 1);
            }
        }

        return map.values()
                .stream()
                .allMatch(i -> i == 0);
    }
}
