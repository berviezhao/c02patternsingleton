package com.bervie.pattern;

import com.bervie.pattern.singleton.register.EnumSingleton;

import java.lang.reflect.Constructor;

/**
 * 从JDK层面就为枚举不备序列化和反射破坏来保驾护航····
 *
 * @author Bervie
 * @date 2019/06/07
 */
public class EnumSingletonReflectTest {
    public static void main(String[] args) {

        try {
            Class<EnumSingleton> clazz = EnumSingleton.class;
            Constructor<EnumSingleton> c = clazz.getDeclaredConstructor(String.class,int.class);
            c.setAccessible(true);
            EnumSingleton obj = c.newInstance("Bervie",666);
            System.out.println(obj);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
