package com.newpi.data.stack;

import java.util.Stack;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date 2021/1/24 14:43
 * @desc:
 */
public class ExpressionEvaluation {

    /**
     * 表达式求值
     *
     * @param exp 3+2*5-4/2
     * @return
     */
    public Integer expression(String[] exp) {
        Stack<String> op = new Stack<>();
        Stack<String> data = new Stack<>();
        Integer value = 0;
        for (String s : exp) {
            if(isNumber(s)){
                data.push(s);
            }else {
                if(op.empty()){
                    op.push(s);
                }else {
                    String op1 = op.peek();
                    if(highPriority(s,op1)){
                        op.push(s);
                    }else {
                        String data1 = data.pop();
                        String data2 = data.pop();
                        value = evaluate(data1,data2,op.pop());
                        data.push(value.toString());
                        op.push(s);
                    }
                }
            }
        }
        while (!op.empty()){
            String data1 = data.pop();
            String data2 = data.pop();

            value = evaluate(data2,data1,op.pop());
            data.push(value.toString());
        }
        return value;
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean highPriority(String s,String op){
        if("-".equals(s)||"+".equals(s)){
            if("*".equals(op)||"/".equals(op)){
                return false;
            }
        }
        return true;
    }

    private Integer evaluate(String data1,String data2,String op){
        Integer value = null;
        if("-".equals(op)){
            value= Integer.parseInt(data1) - Integer.parseInt(data2);
        }
        if("+".equals(op)){
            value= Integer.parseInt(data1)+Integer.parseInt(data2);
        }
        if("*".equals(op)){
            value= Integer.parseInt(data1)*Integer.parseInt(data2);
        }
        if("/".equals(op)){
            value= Integer.parseInt(data1)/Integer.parseInt(data2);
        }
        return value;
    }
}
