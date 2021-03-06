package com.jyx.design.pattern.factory;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-02 18:09
 **/
public class SmsFactory implements Factory {
    public Sender produce() {
        return new SmsSender();
    }
}
