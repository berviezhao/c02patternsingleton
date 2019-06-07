package com.bervie.pattern;

import com.bervie.pattern.singleton.register.ContainerSingleton;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA
 *
 * @author Bervie
 * @date 2019/06/07
 */
public class ContainerSingletonTest {
    public static void main(String[] args) {
        try {
            ConcurrentExecutor.execute(() -> {
                    Object obj = ContainerSingleton.getBean("com.bervie.pattern.Pojo");
                    System.out.println(System.currentTimeMillis()+":"+obj);
            },10,6);
            //对象方便管理，其实属于懒加载
            //存在线程安全问题，
            //虽然ConcurrentHashMap是线程安全的，
            //但是存在线程安全的是getBean中对Object的赋值是不安全的。
            //因此在getBean方法中增加sychronized的关键字，来进行锁
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}