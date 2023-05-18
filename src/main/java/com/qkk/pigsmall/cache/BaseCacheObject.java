package com.qkk.pigsmall.cache;


public abstract class BaseCacheObject {
    private long timestamp;

    public static final long ONE_MINUIT = 60000L;

    protected BaseCacheObject() {
        timestamp = System.currentTimeMillis();
    }

    protected abstract long getTimeOut();

    protected boolean isTimeOut() {
        return System.currentTimeMillis() - timestamp > getTimeOut();
    }

}
