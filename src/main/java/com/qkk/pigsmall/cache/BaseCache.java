package com.qkk.pigsmall.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public abstract class BaseCache<K, V extends BaseCacheObject> {
    private final Map<K, V> cacheMap = new ConcurrentHashMap<>();

    protected abstract int getCacheSize();

    protected abstract V initBaseObject(K key);

    protected V put(K key, V value) {
        if (key == null) {
            return null;
        }
        if (cacheMap.containsKey(key)) {
            cacheMap.put(key, value);
        } else {
            if (cacheMap.size() >= getCacheSize()) {
                cacheMap.clear();
                cacheMap.put(key, value);
            }
        }
        return value;
    }

    protected V get(K key) {
        if (key == null) {
            return null;
        }
        V value = cacheMap.get(key);
        if (value == null || value.isTimeOut()) {
            value = initBaseObject(key);
            if (value != null) {
                cacheMap.put(key, value);
            }
        }
        return value;
    }
}
