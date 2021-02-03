package com.newpi.data.skiplist;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/1/29 10:55 AM
 * @desc:
 */
public class Test {

    @org.junit.Test
    public void testSkipList() {
        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(2);
        skipList.insert(3);
        skipList.insert(4);
        skipList.insert(7);
        skipList.insert(10);
        skipList.insert(9);

        skipList.printAll();

    }

}
