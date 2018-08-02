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

        //定义工厂接口 这样如果有新的sender接入就不需要改动工厂方法，只需要新增加一个工厂类实现工厂接口就ok。 满足 开闭原则 对扩展开放对修改关闭
        SmsFactory smsFactory = new SmsFactory();
        MailFactory mailFactory = new MailFactory();
        Sender smsSender = smsFactory.produce();
        Sender mailSender = mailFactory.produce();
        smsSender.send();
        mailSender.send();

    }
}
