package com.newpi.data.hashtable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/5/18 5:00 PM
 * @desc:
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> implements Map<K, V> {

    private int cacheSize = 16;

    public LRUCache(int cacheSize) {
        super(cacheSize,0.75F,true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        if (size() > cacheSize) {
            return true;
        }
        return false;
    }
}
