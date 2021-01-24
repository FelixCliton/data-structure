package com.newpi.data.stack;

import java.util.Stack;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date 2021/1/24 16:31
 * @desc:
 */
public class BraceMatch {

    public static Boolean validate(String s) {

        if (null == s || "".equals(s)) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                char topChar = stack.pop();
                if (!isMatch(topChar, c)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private static Boolean isMatch(char beforeChar, char afterChar) {
        if (beforeChar == '(' && afterChar == ')'
                || beforeChar == '[' && afterChar == ']'
                || beforeChar == '{' && afterChar == '}') {
            return true;
        }
        return false;
    }
}