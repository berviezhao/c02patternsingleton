package com.bervie.pattern.singleton.lazy;

/**
 * 单例模式-懒汉式单例模式
 * 1、构造方法私有化
 * 2、提供全局访问点getInstance()方法
 * 3、在调用访问点时初始化实例
 * 缺点：
 * 1、线程不安全
 * Created with IntelliJ IDEA
 * Author:Bervie
 * Date:2019-06-02
 */
public class LazySimpleSingleton {
    private static LazySimpleSingleton lazy = null;
    private LazySimpleSingleton(){};
    public static LazySimpleSingleton getInstance(){
        if(lazy==null){
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }
}
