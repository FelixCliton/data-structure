package com.newpi.data.queue;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date 2021/1/24 18:23
 * @desc:
 */
public class MyStack {

    private Queue<String> q1 = new LinkedBlockingQueue<>();

    private Queue<String> q2 = new LinkedBlockingQueue<>();

    public void push(String s) {
        if (q1.isEmpty()) {
            q2.add(s);
        } else {
            q1.add(s);
        }
    }


    public String pop() throws Exception {
        if (q1.isEmpty() && q2.isEmpty()) {
            throw new Exception("stack is empty,operation is invalid.");
        }
        String data = null;
        if (q1.isEmpty()) {
            data = process(q2,q1);
        } else {
            data = process(q1,q2);
        }
        return data;
    }

    private String process(Queue<String> q1, Queue<String> q2) throws Exception {
        if (q1.isEmpty() && !q2.isEmpty()) {
            throw new Exception("operation is invalid.");
        }
        String data = null;
        while (!q1.isEmpty()) {
            data = q1.remove();
            if (q1.isEmpty()) {
                break;
            }
            q2.add(data);
        }
        return data;
    }
}
