package com.jssolo.utils;

/**
 * 自定义运行时异常，精简堆栈信息
 */
public class RuntimeExceptionSmall extends RuntimeException {
    public RuntimeExceptionSmall(String message) {
        super(message, getThrowable(message), false, false);
    }
    private static Throwable getThrowable(String message) {
        StackTraceElement[] stackTrace = new StackTraceElement[1];
        stackTrace[0] = Thread.currentThread().getStackTrace()[3];
        Throwable cause = new Throwable(message);
        cause.setStackTrace(stackTrace);
        return cause;
    }
}
