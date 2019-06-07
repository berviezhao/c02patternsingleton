package com.bervie.pattern.singleton.lazy;

/**
 * 单例模式-懒汉式线程安全单例模式
 * 1、构造方法私有化
 * 2、提供全局访问点getInstance()方法
 * 3、在调用访问点时初始化实例
 * 4、增加synchronized使得线程安全
 * 缺点：
 * 不可避免地还是存在一定的性能问题
 * 方法锁会造成性能问题
 * Created with IntelliJ IDEA
 * Author:Bervie
 * Date:2019-06-02
 */
public class LazySychronizedSingleton {
    private static LazySychronizedSingleton lazy = null;
    private LazySychronizedSingleton(){};
    /**
     * JDK1.6之后对sychronized性能优化了不少
     * 不可避免地还是存在一定的性能问题
     * 方法锁会造成性能问题
     */
    public synchronized static LazySychronizedSingleton getInstance(){
        if(lazy==null){
            lazy = new LazySychronizedSingleton();
        }
        return lazy;
    }
}
