package com.bervie.pattern.singleton.hungry;

/**
 *  单例模式-饿汉式静态单例
 *  1、构造方法私有化
 *  2、在类加载时初始化全局实例
 *  3、提供全局访问点getInstance()方法
 *  4、线程安全
 *  缺点：
 *  不管用不用都会被初始化。浪费内存空间。
 * Author:Bervie
 * Date:2019-06-02
 */
public class HungryStaticSingleton {
    private static final HungryStaticSingleton HUNGRY_STATIC_SINGLETON;
    static {
        HUNGRY_STATIC_SINGLETON = new HungryStaticSingleton();
    }
    private HungryStaticSingleton(){}

    public static HungryStaticSingleton getInstance(){
        return HUNGRY_STATIC_SINGLETON;
    }
}
