package com.bervie.pattern.singleton.threadlocal;

/**
 * Created with IntelliJ IDEA
 * 伪线程安全
 * @author Bervie
 * @date 2019/06/07
 */
public class ThreadLocalSingleton {
    private ThreadLocalSingleton(){}
    private static final ThreadLocal<ThreadLocalSingleton> THREADLOCAL_INSTANCE
            = ThreadLocal.withInitial(ThreadLocalSingleton::new);
    public static ThreadLocalSingleton getInstance(){
        return THREADLOCAL_INSTANCE.get();
    }
}
