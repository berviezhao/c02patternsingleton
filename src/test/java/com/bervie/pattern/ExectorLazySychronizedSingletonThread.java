package com.bervie.pattern;

import com.bervie.pattern.singleton.lazy.LazySychronizedSingleton;

/**
 * Created with IntelliJ IDEA
 * Author:Bervie
 * Date:2019-06-02
 */
public class ExectorLazySychronizedSingletonThread implements Runnable {
    @Override
    public void run() {
        LazySychronizedSingleton lazySychronizedSingleton = LazySychronizedSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+":"+lazySychronizedSingleton);
    }
}
