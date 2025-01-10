package com.jssolo.utils;

/**
 * 自定义运行时异常，去掉堆栈日志打印，仅打印异常信息,请留意由于不打印堆栈信息导致无法定位错误位置
 */
public class RuntimeExceptionOnly extends RuntimeException{
    public RuntimeExceptionOnly(String message) {
        super(message,null,false,false);
    }
}
