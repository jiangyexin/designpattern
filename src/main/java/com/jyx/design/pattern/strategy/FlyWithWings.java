package com.jyx.design.pattern.strategy;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-03 11:44
 **/
public class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("用翅膀飞行");
    }
}
