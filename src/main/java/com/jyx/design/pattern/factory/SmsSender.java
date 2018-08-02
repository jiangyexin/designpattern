package com.jyx.design.pattern.factory;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-02 17:53
 **/
public class SmsSender implements Sender {
    public void send() {
        System.out.println("SmsSender send.");
    }
}
