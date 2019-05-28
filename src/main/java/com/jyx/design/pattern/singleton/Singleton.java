package com.jyx.design.pattern.singleton;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-03 10:26
 **/
public class Singleton {
    /*私有静态防止被引用 赋值为null是延迟加载*/
    private static volatile Singleton instance = null;
    /*构造方法私有防止外部通过new的方式获得对象*/
    private Singleton() {

    }

   /* private static synchronized void syncInit() {
        if (instance == null) {
            instance = new Singleton();
        }
    }*/

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
    }
}
