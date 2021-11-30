package com.example.leetcodeserver.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {
    public static void main(String[] args) {

        GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams49.groupAnagrams(strs);

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a'] = count[c - 'a'] + 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    sb.append((char) ('a' + count[i]));
                    sb.append(i);
                }
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(s);
            map.put(sb.toString(), list);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> r = new HashMap();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a'] = count[c - 'a'] + 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    sb.append((char) count[i] + 'a');
                    sb.append(i);
                }
            }
            String key = sb.toString();
            List<String> orDefault = r.getOrDefault(key, new ArrayList<>());
            orDefault.add(s);
            r.put(key, orDefault);
        }
        return new ArrayList<>(r.values());
    }

}
