package com.newpi.data.stack;

import java.util.Stack;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date 2021/1/24 16:51
 * @desc:
 */
public class Queue {

    private Stack<String> s1 = new Stack<>();
    private Stack<String> s2 = new Stack<>();

    public void add(String s) {
        s1.push(s);
    }

    public String pop() throws Exception {
        if (s1.empty() && s2.empty()) {
            throw new Exception("queue is empty,operation is invalid");
        }
        if (s2.empty()) {
            while (!s1.empty()) {
                String s = s1.pop();
                s2.push(s);
            }
        }
        return s2.pop();
    }

}
