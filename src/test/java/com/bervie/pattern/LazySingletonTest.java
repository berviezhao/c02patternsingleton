package com.bervie.pattern;

/**
 * Created with IntelliJ IDEA
 * Author:Bervie
 * Date:2019-06-02
 */
public class LazySingletonTest {
    public static void main(String[] args) {
        System.out.println("Exctor Start");
        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());
        t1.start();
        t2.start();
        System.out.println("Exctor End");


    }
}
