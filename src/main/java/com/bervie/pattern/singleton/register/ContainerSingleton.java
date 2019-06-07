package com.bervie.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 单例模式-注册式单例
 * 优点：
 * 集中化管理单例类
 * @author Bervie
 * @date 2019/06/07
 */
public class ContainerSingleton {
    private ContainerSingleton(){}
    private static final Map<String,Object> IOC = new ConcurrentHashMap<>();
    public static Object getBean(String className){
        synchronized (IOC) {
            if (!IOC.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    IOC.put(className, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            }
        }
        return IOC.get(className);
    }
}
