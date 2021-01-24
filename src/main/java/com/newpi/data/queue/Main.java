package com.newpi.data.queue;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date 2021/1/24 18:23
 * @desc:
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MyStack stack = new MyStack();
        stack.push("A");
        stack.push("B");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push("C");
        System.out.println(stack.pop());
        stack.push("D");
        stack.push("E");
        System.out.println(stack.pop());
        stack.push("F");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


}
