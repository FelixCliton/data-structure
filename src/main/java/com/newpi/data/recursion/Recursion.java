package com.newpi.data.recursion;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date 2021/1/24 21:10
 * @desc:
 */
public class Recursion {

    /**
     * 练习题1
     * @param n
     * @return
     */
    public  Integer resolve(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return resolve(n-1)+resolve(n-2);
    }

}
