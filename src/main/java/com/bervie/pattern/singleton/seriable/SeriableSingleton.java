package com.bervie.pattern.singleton.seriable;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 * Author:Bervie
 * Date:2019-06-04
 */
//反序列化时导致单例破坏
public class SeriableSingleton implements Serializable {
    /**   序列化就是把内存中的状态通过转换成字节码的形式
        //从而转换一个IO流，写入到其他地方（可以是磁盘、网络IO）
        //内存中状态给永久保存下来
        //反序列化
        //将已经持久化的字节码内容，转换为IO流
        //通过IO流的读取，进而将读取的内容转换为Java对象
        //在转换过程中会重新创建对象new
     */
    private final static SeriableSingleton INSTANCE = new SeriableSingleton();

    private SeriableSingleton() {
    }

    public static SeriableSingleton getInstance() {
        return INSTANCE;
    }

    /**
     * 为了防止反序列化
     * 重新readResolve方法，只不过是覆盖了反序列化出来的对象
     * 还是创建了两次，发生在JVM层面，相对来说比较安全
     * 之前反序列化出来的对象会被GC回收
     * 只不过在创建完后，又重新指向了初始化时候创建的对象
     */
    private Object readResolve(){
        return INSTANCE;
    }
}