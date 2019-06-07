package com.bervie.pattern.singleton.register;

/**
 * 注册式单例-枚举单例
 * @author Bervie
 * @date 2019-06-04
 */
public enum EnumSingleton {
    /**
     * 用于实例化枚举
     */
    INSTANCE;
    private Object data;
    public Object getData(){
        return data;
    }
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
