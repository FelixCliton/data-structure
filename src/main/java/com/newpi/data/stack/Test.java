package com.newpi.data.stack;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date 2021/1/24 15:24
 * @desc:
 */
public class Test {

    @org.junit.Test
    public void expressionEvaluation(){

        String[] exp = new String[]{"2","+","3","*","5","-","4","/","2"};
        ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
        Integer value = expressionEvaluation.expression(exp);
        System.out.println(value);

    }

    @org.junit.Test
    public void BraceMatchTest(){
        String brace1 = new String("[](){}{{[[]]}}[()]");
        String brace2 = new String("[][]{}[}]{}");

        System.out.println(BraceMatch.validate(brace1));
        System.out.println(BraceMatch.validate(brace2));
    }

    @org.junit.Test
    public void queueTest() throws Exception {
        Queue queue  = new Queue();
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        System.out.println(queue.pop());
        queue.add("E");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.add("F");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

}
