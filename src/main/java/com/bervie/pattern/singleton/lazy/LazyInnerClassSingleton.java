package com.bervie.pattern.singleton.lazy;

/**
 * 内部类懒汉式
 * 全程无sychronized关键字
 * 类加载特征：
 * 大类被加载前
 * 先检测有内部类
 * 如果有内部类
 * 会先加载内部类
 * 但不会先执行内部类中的方法，只有被用到时才会调用执行
 *
 * 作业：理解内部类的执行逻辑
 * 解决了线程安全问题，但会被反射，类安全问题
 * @author Bervie
 * @date 2019/06/04
 */
public class LazyInnerClassSingleton {
    /**
    //虽然构造方法私有化了，但是，逃不过反射法眼
    private LazyInnerClassSingleton(){}
    */
    private LazyInnerClassSingleton(){
        if (LazyHolder.LAZY!=null){
            throw new RuntimeException("不允许构建多个实例");
        }
    }
    /**
     * 懒汉式单例
     * LazyHolder里的逻辑需要等到外部方法调用时才执行
     * 巧妙利用了内部类的特性
     * JVM底层执行逻辑，完美避免线程安全问题
     */
    public static LazyInnerClassSingleton getInstance(){return LazyHolder.LAZY;}
    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
