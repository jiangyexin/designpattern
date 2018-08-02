package com.jyx.design.pattern.factory;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-02 17:58
 **/
public class FactoryTest {
    public static void main(String[] args) {
        SenderFactory senderFactory = new SenderFactory();
        Sender sms = senderFactory.produce(SenderFactory.SMS_TYPE);
        Sender mail = senderFactory.produce(SenderFactory.MAIL_TYPE);
        Sender unknow = senderFactory.produce(null);
        sms.send();
        mail.send();
    }
}
