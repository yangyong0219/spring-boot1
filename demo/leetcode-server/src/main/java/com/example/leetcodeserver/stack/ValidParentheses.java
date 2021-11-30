package com.example.leetcodeserver.stack;

import org.yaml.snakeyaml.util.ArrayStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid = validParentheses.isValid("()[]{}");
        System.out.println(valid);

    }

    public boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (pairs.containsValue(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

//        Stack<Character> stack = new Stack<>();
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                stack.push(')');
//            } else if (c == '[') {
//                stack.push(']');
//            } else if (c == '{') {
//                stack.push('}');
//            } else {
//                if (stack.isEmpty() || stack.pop() != c) {
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
    }

}
