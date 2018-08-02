package com.jyx.design.pattern.factory;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-02 17:52
 **/
public class MailSender implements Sender {
    public void send() {
        System.out.println("MailSender send.");
    }
}
