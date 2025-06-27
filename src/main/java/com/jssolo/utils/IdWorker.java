package com.jssolo.utils;

/**
 * @author: ZYan
 */
public class IdWorker {
    private static final SnowflakeIdWorker INSTANCE = new SnowflakeIdWorker(1, 1);

    public static long nextSnowflakeId() {
        return INSTANCE.nextId();
    }
}
