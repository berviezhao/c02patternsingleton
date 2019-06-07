package com.bervie.pattern;

import com.bervie.pattern.singleton.lazy.LazyInnerClassSingleton;

import java.lang.reflect.Constructor;

/**
 * Created with IntelliJ IDEA
 * Author:Bervie
 * Date:2019-06-04
 */
public class LazyInnerClassSingletonTest {
    public static void main(String[] args) {
        try {
            Object o2 = LazyInnerClassSingleton.getInstance();
            System.out.println(o2.hashCode());
            Class<?> clazz = LazyInnerClassSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            Object o1 = c.newInstance();
            //Object o2 = LazyInnerClassSingleton.getInstance();
            System.out.println(o1==o2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}