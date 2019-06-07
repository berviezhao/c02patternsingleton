package com.bervie.pattern;

import com.bervie.pattern.singleton.threadlocal.ThreadLocalSingleton;

/**
 * 使用两个线程通过调试演示整个过程
 * Author:Bervie
 * Date:2019-06-02
 */
public class ExectorThread implements Runnable{

    @Override
    public void run() {
        //LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();

        System.out.println(Thread.currentThread().getName()+":"+ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName()+":"+ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName()+":"+ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName()+":"+ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName()+":"+ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName()+":"+ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName()+":"+ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName()+":"+ThreadLocalSingleton.getInstance());
    }
}
