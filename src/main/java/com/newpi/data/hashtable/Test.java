package com.newpi.data.hashtable;

import java.util.LinkedHashMap;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/5/18 4:52 PM
 * @desc:
 */
public class Test {

    public static void main(String[] args) {
       LRUCache<String,String> cache = new LRUCache<>(16);
        for (int i = 0; i < 16; i++) {
            cache.put(String.valueOf(i),String.valueOf(i));
        }
        System.out.println(cache);
        cache.put("17","17");
        System.out.println(cache);
        cache.get("10");
        System.out.println(cache);
    }

}
