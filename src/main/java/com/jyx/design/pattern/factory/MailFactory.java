package com.jyx.design.pattern.factory;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-02 18:10
 **/
public class MailFactory implements Factory {
    public Sender produce() {
        return new MailSender();
    }
}
