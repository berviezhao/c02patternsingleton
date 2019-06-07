package com.bervie.pattern.singleton.lazy;

/**
 * sychronized 共享资源，共享资源会存在，读写竞争
 * 不可避免地还是存在一定的性能问题
 * 可以将sychronized放在方法内部
 * Author:Bervie
 * Date:2019-06-03
 */
public class LazyDoubleCheckSingleton {
    private static LazyDoubleCheckSingleton lazy = null;
    private LazyDoubleCheckSingleton(){};
    /**
     * 双重检查锁
     * 不可避免地还是存在一定的性能问题
     * 可以将sychronized放在方法内部
     */
    public static LazyDoubleCheckSingleton getInstance(){
        if(lazy==null){
            synchronized(LazyDoubleCheckSingleton.class) {
                if (lazy==null) {
                    lazy = new LazyDoubleCheckSingleton();
                    //CPU执行会转化JVM指令执行
                    //2、3会指令重排序，volatile线程共享关键字
                    //1、分配内存给对象
                    //2、初始化对象
                    //3、将初始化好的对象和内存地址建立关联，赋值
                    //4、用户初次访问
                }
            }
        }
        return lazy;
    }
}
