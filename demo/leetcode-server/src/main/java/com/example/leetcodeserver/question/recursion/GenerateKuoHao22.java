package com.example.leetcodeserver.question.recursion;

import java.util.*;

public class GenerateKuoHao22 {
    public static void main(String[] args) {
        GenerateKuoHao22 generateKuoHao22 = new GenerateKuoHao22();
        List<String> strings = generateKuoHao22.generateParenthesis(3);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<>();
        generateParenthesis(n, n, "", r);
        return r;
    }

    private void generateParenthesis(int left, int right, String s, List<String> r) {
        if (left == 0 && right == 0) {
            r.add(s);
            return;
        }
        if (left > 0) {
            String s1 = s + "(";
            generateParenthesis(left-1, right, s1, r);
        }
        if (left < right) {
            String s1 = s + ")";
            generateParenthesis(left, right-1, s1, r);
        }
    }
}
