package com.example.leetcodeserver.question.stack;

import java.util.HashMap;
import java.util.Map;

public class ActiveCharacter242 {
    public static void main(String[] args) {
        ActiveCharacter242 activeCharacter242 = new ActiveCharacter242();
        boolean anagram = activeCharacter242.isAnagram("hppay", "ppakyh");
        System.out.println(anagram);

    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;



//        int[] dic = new int[26];
//        for (char c : s.toCharArray()) {
//            dic[c - 'a'] = dic[c - 'a'] + 1;
//        }
//        for (char c : t.toCharArray()) {
//            dic[c - 'a'] = dic[c - 'a'] - 1;
//            if (dic[c - 'a'] < 0) {
//                return false;
//            }
//        }
//        return true;
    }
}
