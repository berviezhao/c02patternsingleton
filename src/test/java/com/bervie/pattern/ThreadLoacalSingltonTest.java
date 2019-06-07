package com.bervie.pattern;

import com.bervie.pattern.singleton.threadlocal.ThreadLocalSingleton;

/**
 * Created with IntelliJ IDEA
 *
 * @author Bervie
 * @date 2019/06/07
 */
public class ThreadLoacalSingltonTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());

        t1.start();
        t2.start();
        System.out.println("END");
    }
}
